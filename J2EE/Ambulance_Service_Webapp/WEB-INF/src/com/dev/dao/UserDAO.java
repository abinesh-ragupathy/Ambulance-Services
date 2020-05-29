/**
 @Author : Palani kannan

*/

package com.dev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import com.dev.util.Distance;

public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO(){}
	
	public static UserDAO initialize()
	{
		if(userDAO==null)
		{
			userDAO=new UserDAO();
		}
		return userDAO;
	}
	

	public static boolean authenticateUser(String username,String password)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_user where username='"+username+"' and password='"+password+"'";
			
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean checkUserExistence(String username)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_user where username='"+username+"'";
			
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean addUser(String username,String password,String name,String sex,String city,String phone)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into m_user (username,password,name,sex,city,phone) values('"+username+"','"+password+"','"+name+"','"+sex+"','"+city+"','"+phone+"')";
			
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public static boolean changeUserPassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_user set password='"+newPassword+"' where username='"+username+"'";
			
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	public static ResultSet getPoliceStationLocations()
	{
		System.out.println("police");
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from p_police_station";
			
			
			resultSet = statement.executeQuery(sql);
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getNeibhursLocations()
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_neibhur";
			
			
			resultSet = statement.executeQuery(sql);
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getHospitalsLocations()
	{
		System.out.println("method Hospital ");
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from h_hospital";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	
	public static String getNearPoliceStationLocations()
	{
		boolean flag=false;
		String sql = "";
		StringBuffer sb=new StringBuffer();
		int k=2;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from p_police_station where dist < 4000  order by dist asc";
			
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
			k=k+1;
				sb.append(resultSet.getString(2)+","+resultSet.getString(5)+"~"+resultSet.getString(13)+"~"+resultSet.getString(14)+"~"+resultSet.getString(10));
				sb.append("@");
			}
			
			if(k==2)
			{
				sb.append("empty");
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	
	
	public static String getNeibhurLocations()
	{
		boolean flag=false;
		String sql = "";
		StringBuffer sb=new StringBuffer();
		int k=2;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_neibhur where dist < 4000  order by dist asc";
			System.out.println("sql :"+sql);
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
			k=k+1;
				sb.append(resultSet.getString(2)+"("+resultSet.getString(4)+")~"+resultSet.getString(5)+"~"+resultSet.getString(6)+"~"+resultSet.getString(4));
				sb.append("@");
			}
			
			if(k==2)
			{
				sb.append("empty");
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String getNearHospitalsLocations()
	{
		boolean flag=false;
		String sql = "";
		StringBuffer sb=new StringBuffer();
		int k=2;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from h_hospital where dist < 1000  order by dist asc";
			
			
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
			k=k+1;
				sb.append(resultSet.getString(2)+"~"+resultSet.getString(13)+"~"+resultSet.getString(14));
				sb.append("@");
			}
			
			if(k==2)
			{
				sb.append("empty");
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static boolean updatedistance(String sno,Double dist)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update p_police_station set dist='"+dist+"' where code='"+sno+"'";
			
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateNeibhurdistance(String sno,Double dist)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_neibhur set dist='"+dist+"' where n_code='"+sno+"'";
			
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean updatedistanceHosp(String sno,Double dist)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update h_hospital set dist='"+dist+"' where H_code='"+sno+"'";
			
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean addlinks(String userid, String links)
	{
		System.out.println("inside Links");
		boolean flag=false;
		boolean f = false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			
			String chksql = "select m_userid from m_links where m_userid = '"+userid+"'";
			resultSet = statement.executeQuery(chksql);
			while(resultSet.next())
			{
				f = true;
			}
			
			if(f)
			{
				String sqll = "update m_links set m_userid = '"+userid+"', m_link ='"+links+"' where m_userid = '"+userid+"' ";
				
				System.out.println(sqll);
				i = statement.executeUpdate(sqll);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println(flag);
			}
			
			else 
			{
				sql = "insert into m_links(m_userid, m_link) values('"+userid+"', '"+links+"')";
				
				System.out.println(sql);
				i = statement.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println(flag);
			}
			
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
}
