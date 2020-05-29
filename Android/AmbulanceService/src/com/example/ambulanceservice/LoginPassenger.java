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
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPassenger extends Activity {

	private EditText etPid;
	private EditText etpPass;
	private Button btnPLogin;
	private TextView tvRegPassenger;
	
	private SharedPreferences pref;
	String response;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_passenger);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
        
        pref = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        
        
		
		etPid = (EditText)findViewById(R.id.et_pid);
		etpPass = (EditText)findViewById(R.id.et_pPass);
		
		btnPLogin = (Button)findViewById(R.id.btnPLogin);
		tvRegPassenger = (TextView)findViewById(R.id.tvRegPassenger);
		
		
		btnPLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String passengerid = etPid.getText().toString();
				String password = etpPass.getText().toString();
				
				if(passengerid.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter Passenger ID", Toast.LENGTH_LONG).show();
				}

				if(password.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
				}
				
				else{
					
					try{
						
						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("passengerid",passengerid));
						nameValuePairs.add(new BasicNameValuePair("password",password));
						
						
						response = CustomHttpClient.executeHttpPost(Global.URL + "Login.jsp", nameValuePairs);
						
						//Toast.makeText(getApplicationContext(), "response: " + response, Toast.LENGTH_LONG).show();
						
						if (response.trim().equalsIgnoreCase("true")) 
						{
							Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
							
							SharedPreferences.Editor editor = pref.edit();
				            editor.putString("passengerid", passengerid);
				            editor.putString("password", password);
				            editor.commit();
				            
							Intent intent = new Intent(getApplicationContext(), Home.class);
							startActivity(intent);
							LoginPassenger.this.finish();
						}
						
						else
						{
							Toast.makeText(getApplicationContext(), "Please Enter Correct User Id and Password!!!", Toast.LENGTH_LONG).show();
						}
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
			}
		});
		
		
		
		tvRegPassenger.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), PassengerRegister.class);
				startActivity(i);
				LoginPassenger.this.finish();
			}
		});
		
	}

}
