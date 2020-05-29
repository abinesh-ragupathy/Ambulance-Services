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

public class GlobalIp extends Activity {

	private EditText etIpAddress;
	private Button btnIpAddress;
	
	public static String GlobalIp = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_global_ip);
		
		
		etIpAddress = (EditText)findViewById(R.id.ipAddress);
		btnIpAddress = (Button)findViewById(R.id.btnIpAddress);
		
		btnIpAddress.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GlobalIp = etIpAddress.getText().toString().trim();
				
				if(GlobalIp.equals("")){
					Toast.makeText(getApplicationContext(), "Please Enter IP Address", Toast.LENGTH_LONG).show();
				}
				
				else {
					Toast.makeText(getApplicationContext(), GlobalIp.trim(), Toast.LENGTH_LONG).show();
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}

			}
		});
		
	}
}
