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
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Home extends Activity {

	private Button btnSendMessage;
	private Button btnCallDriver;
	private SharedPreferences pref;
	String userID = "";

	private double latitude;
	private double longitude;

	GPSTracker gps;
	String response = "";
	private Button btnLogout;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		pref = getApplicationContext().getSharedPreferences("MyPref",
				Context.MODE_PRIVATE);
		userID = pref.getString("passengerid", "");

		gps = new GPSTracker(Home.this);

		latitude = gps.getLatitude();
		longitude = gps.getLongitude();

		btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
		btnCallDriver = (Button) findViewById(R.id.btnCallDriver);
		btnLogout = (Button)findViewById(R.id.btnLogout);

		btnSendMessage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {

					// check if GPS enabled
					if (gps.canGetLocation()) {
						
						Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
						
						String phoneNo = getAmbulancePhone(userID, latitude, longitude);
						
						String msg= "SMS From "+userID+", accident happened in this place. Tap To view Map Please click the below link http://www.google.com/maps/place/"+latitude+","+longitude;
	                    
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNo.trim(), null, msg, null, null);
						
						
						//Toast.makeText(getApplicationContext(), "phoneNo: " + response, Toast.LENGTH_LONG).show();
						
					} else {
						gps.showSettingsAlert();
					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});

		btnCallDriver.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String phoneNo = getAmbulancePhone(userID, latitude, longitude);
				
				Intent inCall = new Intent(Intent.ACTION_CALL);
				inCall.setData(Uri.parse("tel:"+phoneNo.trim()));
				startActivity(inCall);
			}
		});
		
		
		btnLogout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(), GlobalIp.class);
				startActivity(i);
				Home.this.finish();
				
			}
		});
	}
	
	public String getAmbulancePhone(String userid,Double lat,Double longi)
	{
		//Toast.makeText(getApplicationContext(), "getAmbulancePhone", Toast.LENGTH_LONG).show();
		
		
        
		
		try{
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("pID",userID.trim()));
			nameValuePairs.add(new BasicNameValuePair("latitude",String.valueOf(latitude)));
			nameValuePairs.add(new BasicNameValuePair("longitude",String.valueOf(longitude)));
			
			response = CustomHttpClient.executeHttpPost(Global.URL + "GetNearAmbulance.jsp", nameValuePairs);
			
			//Toast.makeText(getApplicationContext(),"response: " + response, Toast.LENGTH_LONG).show();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return response;
	}
	
}
