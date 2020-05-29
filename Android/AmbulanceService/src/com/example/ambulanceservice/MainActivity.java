package com.example.ambulanceservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button btnPassenger;
	private Button btnDriver;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnPassenger = (Button)findViewById(R.id.btnPassenger);
        btnDriver = (Button)findViewById(R.id.btnDriver);
        
        btnPassenger.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), LoginPassenger.class);
				startActivity(i);
			}
		});
        
        
        btnDriver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), LoginDriver.class);
				//Intent i = new Intent(getApplicationContext(), DriverHome.class);
				startActivity(i);
			}
		});
        
    }
}
