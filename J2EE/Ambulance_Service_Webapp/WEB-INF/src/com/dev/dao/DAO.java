
package com.dev.dao;

import java.sql.Connection;

import java.sql.DriverManager;

import com.dev.util.Utility;



public class DAO 
{
	private static DAO dao=null;
	private DAO()
	{
		
	}
	public static DAO getInstance()
	{
		if(dao==null)
		{
			dao=new DAO();
		}
		return dao;
	}
	
	public static Connection getConnection()
	{
		Connection con=null;
		try 
		{

			Class.forName(Utility.getPro("Driver"));
			con=DriverManager.getConnection(Utility.getPro("URL"),Utility.getPro("User"),Utility.getPro("Pass"));

		}
		catch (Exception e) 
		{
			System.out.println("Exception in DAO-->getConnection() : ");
			e.printStackTrace();
		}
		return con;
	}
}
