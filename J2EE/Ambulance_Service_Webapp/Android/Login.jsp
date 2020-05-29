<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.android.data.*"%>
<%!
	boolean  flag=false;
	String info = "Opps,Something Went Wrong Try Again..";
	String res = "";
	
%>
<%

if(request.getParameter("passengerid") != null)
{
	StringBuffer sb  = new StringBuffer();
	
	String passengerid = request.getParameter("passengerid");
	System.out.println("passengerid=======  "+passengerid);
	

	String password = request.getParameter("password");
	System.out.println("password=======  "+password);
	
	
	flag = UserDao.passengerLogin(passengerid, password);
	
	out.println(flag);
}


else{
	out.println(flag);
}

%>