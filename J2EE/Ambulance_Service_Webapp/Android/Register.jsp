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
	

	String userName = request.getParameter("userName");
	System.out.println("userName=======  "+userName);
	
	

	String userEmailId = request.getParameter("userEmailId");
	System.out.println("userEmailId=======  "+userEmailId);
	
	
	String userPhone = request.getParameter("userPhone");
	System.out.println("userPhone=======  "+userPhone);
	

	
	res = UserDao.AddPassenger(passengerid, password, userName, userEmailId, userPhone);
	out.println(res);
}


else{
	out.println("No Value");
}

%>