package com.example.ambulanceservice;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DriverHome extends Activity {

	private Button btnGetNearHospital;
	private Button btnLogout;

	private SharedPreferences pref;
	String userID = "";

	private double latitude;
	private double longitude;

	GPSTracker gps;
	String response = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_driver_home);
		

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		pref = getApplicationContext().getSharedPreferences("MyPref",
				Context.MODE_PRIVATE);
		userID = pref.getString("passengerid", "");

		gps = new GPSTracker(DriverHome.this);

		latitude = gps.getLatitude();
		longitude = gps.getLongitude();
		
		btnGetNearHospital = (Button)findViewById(R.id.btnGetNearHospital);
		btnGetNearHospital.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				try
				{
					// check if GPS enabled
					if (gps.canGetLocation()) 
					{
						Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
						String link = getHospitalLocation(userID, latitude, longitude);
						String s[] = link.split("~");
						
						String lat = s[0];
						String lon = s[1];
						
						Uri mapLink = Uri.parse("http://maps.google.com/maps?q=loc:"+lat.trim()+","+lon.trim());
						Intent i = new Intent(Intent.ACTION_VIEW, mapLink);
						i.setPackage("com.google.android.apps.maps");
						startActivity(i);
					}
					
					else {
						gps.showSettingsAlert();
					}
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		
		
		
		btnLogout = (Button)findViewById(R.id.btnDLogout);
		btnLogout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), GlobalIp.class);
				startActivity(i);
				DriverHome.this.finish();
			}
		});
		
	}
	
	
	
	public String getHospitalLocation(String userid,Double lat,Double longi)
	{
		//Toast.makeText(getApplicationContext(), "getHospitalLocation", Toast.LENGTH_LONG).show();
		String link = "";
		try{
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("pID",userID.trim()));
			nameValuePairs.add(new BasicNameValuePair("latitude",String.valueOf(latitude)));
			nameValuePairs.add(new BasicNameValuePair("longitude",String.valueOf(longitude)));
			
			response = CustomHttpClient.executeHttpPost(Global.URL + "GetNearHospitals.jsp", nameValuePairs);
			
			String ss[] = response.split("~");
			String phone = ss[0];
			String sLat = ss[1];
			String sLon = ss[2];
			
			//link = "http://www.google.com/maps/place/"+sLat+","+sLon;
			link = sLat + "~" + sLon;
			//Toast.makeText(getApplicationContext(),"response: " + response, Toast.LENGTH_LONG).show();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return link;
	}
}
