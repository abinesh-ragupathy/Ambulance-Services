<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.android.data.*"%>
<%!
	boolean  flag=false;
	String info = "Opps,Something Went Wrong Try Again..";
	List<String> res;
	String distance;
%>
<%

if(request.getParameter("latitude") != null)
{
	StringBuffer sb  = new StringBuffer();

	String latitude = request.getParameter("latitude");
	System.out.println("latitude=======  "+latitude);
	

	String longitude = request.getParameter("longitude");
	System.out.println("longitude=======  "+longitude);
	
	
	res = UserDao.getAlertMessage(latitude, longitude);
	out.println(res);
}


else{
	out.println(res);
}

%>