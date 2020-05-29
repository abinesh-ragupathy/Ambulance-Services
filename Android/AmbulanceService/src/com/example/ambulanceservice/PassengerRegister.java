package com.example.ambulanceservice;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;

import android.app.Activity;
import android.content.Intent;
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

public class PassengerRegister extends Activity {
	
	private EditText etpassengerid;
	private EditText etPassword;
	private EditText etUserName;
	private EditText etUserEmailId;
	private EditText etUserPhone;
	private Button btn_reg;
	private TextView tvLoginPassenger;
	
	String response;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_passenger_register);
		
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		etpassengerid = (EditText)findViewById(R.id.etUserId);
		etPassword = (EditText)findViewById(R.id.etPassword);
		etUserName = (EditText)findViewById(R.id.etUserName);
		etUserEmailId = (EditText)findViewById(R.id.etUserEmailId);
		etUserPhone = (EditText)findViewById(R.id.etUserPhone);
		btn_reg = (Button)findViewById(R.id.btn_reg);
		tvLoginPassenger = (TextView)findViewById(R.id.tvLoginPassenger);
		
		tvLoginPassenger.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), LoginPassenger.class);
				startActivity(i);
				PassengerRegister.this.finish();
			}
		});
		
		
		btn_reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String passengerid = etpassengerid.getText().toString().trim();
				String password = etPassword.getText().toString().trim();
				String userName = etUserName.getText().toString().trim();
				String userEmailId = etUserEmailId.getText().toString().trim();
				String userPhone = etUserPhone.getText().toString().trim();
				
				if(passengerid.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter Passenger ID", Toast.LENGTH_LONG).show();
				}

				if(password.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
				}

				if(userName.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter User Name", Toast.LENGTH_LONG).show();
				}

				if(userEmailId.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter Email ID", Toast.LENGTH_LONG).show();
				}

				if(userPhone.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter Phone Number", Toast.LENGTH_LONG).show();
				}
				
				else{
					
					try{
						
						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
						nameValuePairs.add(new BasicNameValuePair("passengerid",passengerid));
						nameValuePairs.add(new BasicNameValuePair("password",password));
						nameValuePairs.add(new BasicNameValuePair("userName",userName));
						nameValuePairs.add(new BasicNameValuePair("userEmailId",userEmailId));
						nameValuePairs.add(new BasicNameValuePair("userPhone",userPhone));
						
						
						response = CustomHttpClient.executeHttpPost(Global.URL + "Register.jsp", nameValuePairs);
						
						if (response.trim().equalsIgnoreCase("1")) 
						{
							Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_LONG).show();
							Intent intent = new Intent(getApplicationContext(), MainActivity.class);
							startActivity(intent);
							PassengerRegister.this.finish();
						}
						
						else if (response.trim().equalsIgnoreCase("2")) {
							Toast.makeText(getApplicationContext(), "You Are Already Existing!!!", Toast.LENGTH_LONG).show();
							Intent intent = new Intent(getApplicationContext(), MainActivity.class);
							startActivity(intent);
							PassengerRegister.this.finish();
						}
						
						else
						{
							Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_LONG).show();
						}
						
						
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
				
				
				
				
			}
		});
		
		
		
	}
}
