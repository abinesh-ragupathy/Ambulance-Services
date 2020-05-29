package com.example.ambulanceservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginDriver extends Activity {

	private EditText etDid;
	private EditText etDPass;
	private Button btnDLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_driver);
		
		
		etDid = (EditText)findViewById(R.id.et_did);
		etDPass = (EditText)findViewById(R.id.et_dPass);
		
		btnDLogin = (Button)findViewById(R.id.btnDLogin);
		
		btnDLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String driverId = etDid.getText().toString().trim();
				String driverPass = etDPass.getText().toString().trim();
				
				if(driverId.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Please Enter Driver ID!!!", Toast.LENGTH_LONG).show();
					return;
				}
				
				if(etDPass.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Please Enter Driver Password!!!", Toast.LENGTH_LONG).show();
					return;
				}
				
				else {
					if(driverId.equals("driver") & driverPass.equals("driver"))
					{
						Intent i = new Intent(getApplicationContext(), DriverHome.class);
						startActivity(i);
					}
					
					else
					{
						Toast.makeText(getApplicationContext(), "Incorrect Drier ID and Password!!!", Toast.LENGTH_LONG).show();
					}
				}
			}
		});
		
	}
}
