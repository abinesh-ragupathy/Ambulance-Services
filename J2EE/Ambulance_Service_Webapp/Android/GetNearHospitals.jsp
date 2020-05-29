<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.android.data.*"%>
<%!
	boolean  flag=false;
	String info = "Opps,Something Went Wrong Try Again..";
	String res = "";
	String distance;
%>
<%

if(request.getParameter("pID") != null)
{
	StringBuffer sb  = new StringBuffer();
	
	String latitude = request.getParameter("latitude");
	System.out.println("latitude===hos====  "+latitude);
	
	
	String longitude = request.getParameter("longitude");
	System.out.println("longitude===hos====  "+longitude);
	
	
	res = UserDao.getHospitalLocations(latitude, longitude);
	System.out.println("res===hos====  "+res);
	out.println(res);
}


else{
	out.println(res);
}

%>