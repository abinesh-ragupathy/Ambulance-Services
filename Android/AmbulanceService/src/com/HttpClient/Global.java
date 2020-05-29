package com.HttpClient;

import com.example.ambulanceservice.GlobalIp;



public class Global {
	
	static String ipaddress = GlobalIp.GlobalIp.trim();
	
    //public static final String URL = "http://"+ipaddress+":8080/Ambulance_Service_Webapp/";
    //public static final String URL = "http://"+ipaddress+":8080/Ambulance_Service_Webapp/Android/";
    public static final String URL = "http://192.168.1.9:8080/Ambulance_Service_Webapp/Android/";
}
