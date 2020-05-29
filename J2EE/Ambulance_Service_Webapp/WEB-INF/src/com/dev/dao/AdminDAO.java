
package com.dev.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static Statement stmt = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO(){}
	
	public static AdminDAO initialize()
	{
		if(adminDAO==null)
		{
			adminDAO=new AdminDAO();
		}
		return adminDAO;
	}
	
	public static boolean loginCheck(String username,String password)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_admin where admin_id='"+username+"' and admin_password='"+password+"'";
			System.out.println("********** Investigator Login Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>loginCheck(String username,String password) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean changePassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_admin set admin_password='"+newPassword+"' where admin_id='"+username+"'";
			System.out.println("********** Change Investigator Password Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Change Password status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	public static String getAdminName(String username)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select username from m_user where username='"+username+"'";
			System.out.println("********** Get Investigator Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("Admin Name["+username+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getAdminName(String username) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	
	public static ResultSet getAdminProfile(int adminId) 
	{
		String sql = "";
		
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_admin where id='"+adminId+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getAdminProfile(int adminId): ");
			e.printStackTrace();
		}
		return resultSet;
	}


	public static String getUserName(int userId)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select name from m_user where u_id='"+userId+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("User Name["+userId+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getUserName(int UserId) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	
	
	public static int getUserId(String username)
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select u_id from m_user where username='"+username+"'";
			System.out.println("********** Get User Id By Username Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("User Id["+username+"]: "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getUserId(String username) : ");
			e.printStackTrace();
		}
		return id;
	}
	public static boolean checkhospital(String Hospital_name)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from h_hospital where Hospital_name='"+Hospital_name+"'";
			System.out.println("********** Check Hospitalname Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Hospital name existance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkHospitalname(String Hospital_name) : ");
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean checkAmbulance(String ambulance_loc_name)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from p_ambulance where ambulance_loc_name='"+ambulance_loc_name+"'";
			System.out.println("********** Check policestation Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Police Station name existance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkPoliceStationname(String PoliceStation) : ");
			e.printStackTrace();
		}
		return flag;
	}
	public static ResultSet getHospital1(String check) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from h_hospital where H_code='"+check+"'");
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getHospital() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getHospital() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from h_hospital ");
			
		
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getHospital() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getAmbulance() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from p_ambulance");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getpolice() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	public static ResultSet UdatAmbulance(String id) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from p_ambulance where code='"+id+"'");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>UdatAmbulance() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getpolice(String ambulance_loc_name) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from p_ambulance where ambulance_loc_name='"+ambulance_loc_name+"'");
			System.out.println("*****************"+resultSet);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getpolices(int code)  : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static boolean addhospital(String Hospital_name,String Address1,String Address2,String Area,String city,String state,String pin,String land_line,String cell_no1,String remarks,String latitude,String logitude)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into h_hospital(Hospital_name,Address1,Address2,Area,city,state,pin,land_line,cell_no1,remarks,latitude,logitude) values('"+Hospital_name+"','"+Address1+"','"+Address2+"','"+Area+"','"+city+"','"+state+"','"+pin+"','"+land_line+"','"+cell_no1+"','"+remarks+"','"+latitude+"','"+logitude+"')";
			System.out.println("********** Add Route Land Mark Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add Route Land Mark Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>addhospital() : ");
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean updateAmbulance(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update p_ambulance set ambulance_loc_name='"+list.get(0)+"', Address1='"+list.get(1)+"',Address2='"+list.get(2)+"',Area='"+list.get(3)+"',City='"+list.get(4)+"',state='"+list.get(5)+"',pin='"+list.get(6)+"',land_line='"+list.get(7)+"',cell_no1='"+list.get(8)+"',remarks='"+list.get(9)+"',latitude='"+list.get(10)+"',logitude='"+list.get(11)+"' where code='"+list.get(12)+"'";
			System.out.println("**********Update Police station Details Info**********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Route Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updatepolicestationDetails(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean addAmbulance(String police_station_name,String Address1,String Address2,String Area,String City,String state,String pin,String land_line,String cell_no1,String remarks,String latitude,String logitude)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into p_ambulance(ambulance_loc_name,Address1,Address2,Area,City,state,pin,land_line,cell_no1,remarks,latitude,logitude) values('"+police_station_name+"','"+Address1+"','"+Address2+"','"+Area+"','"+City+"','"+state+"','"+pin+"','"+land_line+"','"+cell_no1+"','"+remarks+"','"+latitude+"','"+logitude+"')";
			System.out.println("********** Add ambulance Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add Route Land Mark Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>addAmbulance() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
		public static boolean checkadminoldpassword(String adminid, String oldpass) {
		boolean flag=false;
		String sql = "";
		
		String urlkid="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_admin where username='"+adminid+"' and password='"+oldpass+"'";
			System.out.println("********** its url query**********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>loginCheck(String username,String password) : ");
			e.printStackTrace();
		}
		return flag;
}
		//edit
		public static boolean edithospital(String Hospital_name,String Address1,String Address2,String Area,String city,String state,String pin,String land_line,String cell_no1,String remarks,String latitude,String logitude,String chk)
		{
			boolean flag=false;
			String sql = "";
			int i=0;
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "update h_hospital set Hospital_name='"+Hospital_name+"', Address1='"+Address1+"',Address2='"+Address2+"',Area='"+Area+"',City='"+city+"',state='"+state+"',pin='"+pin+"',land_line='"+land_line+"',cell_no1='"+cell_no1+"',remarks='"+remarks+"',latitude='"+latitude+"',logitude='"+logitude+"' where H_code='"+chk+"'";
				System.out.println("********** Add Route Land Mark Details Info **********");
				System.out.println(sql);
				i = statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
				System.out.println("Add Route Land Mark Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==>addhospital() : ");
				e.printStackTrace();
			}
			return flag;
		}
		
		public static boolean checkhospital2(String hno)
		{
			boolean flag=false;
			String sql = "";
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "select H_code from h_hospital where H_code='"+hno+"'";
				System.out.println("********** Check Hospitalname Existance Info **********");
				System.out.println(sql);
				resultSet = statement.executeQuery(sql);
				while(resultSet.next())
				{
					flag=true;
				}
				System.out.println("Hospital name existance : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==>checkHospitalname(String Hospital_name) : ");
				e.printStackTrace();
			}
			return flag;
		}
		
		public static boolean checkhospital3(String hno)
		{
			boolean flag=false;
			String sql = "";
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "select H_code from h_hospital where H_code='"+hno+"'";
				System.out.println("********** Check Hospitalname Existance Info **********");
				System.out.println(sql);
				resultSet = statement.executeQuery(sql);
				while(resultSet.next())
				{
					flag=true;
				}
				System.out.println("Hospital name existance : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==>checkHospitalname(String Hospital_name) : ");
				e.printStackTrace();
			}
			return flag;
		}
		public static boolean deletehospital(String hno)
		{
			boolean flag=false;
			String sql = "";
			int i=0;
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "delete from h_hospital where H_code='"+hno+"'";
				System.out.println("********** Add Route Land Mark Details Info **********");
				System.out.println(sql);
				i = statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
				System.out.println("Add Route Land Mark Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==>addhospital() : ");
				e.printStackTrace();
			}
			return flag;
		}
		
		public static boolean checkAmbulanceNo(String hno)
		{
			boolean flag=false;
			String sql = "";
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "select code from p_ambulance where code='"+hno+"'";
				System.out.println("********** Check Hospitalname Existance Info **********");
				System.out.println(sql);
				resultSet = statement.executeQuery(sql);
				while(resultSet.next())
				{
					flag=true;
				}
				System.out.println("Hospital name existance : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==>checkHospitalname(String Hospital_name) : ");
				e.printStackTrace();
			}
			return flag;
		}
		
		public static boolean deleteAmbulance(String hno)
		{
			boolean flag=false;
			String sql = "";
			int i=0;
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "delete from p_ambulance where code='"+hno+"'";
				System.out.println("********** Add Route Land Mark Details Info **********");
				System.out.println(sql);
				i = statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
				System.out.println("Add Route Land Mark Status : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==>addhospital() : ");
				e.printStackTrace();
			}
			return flag;
		}
		
	
		
		public static ResultSet getcheckAmbulanceno() 
		{
			String sql = "";
			
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "select code from p_ambulance ";
				System.out.println(sql);
				resultSet = statement.executeQuery(sql);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-getAdminProfile(int adminId): ");
				e.printStackTrace();
			}
			return resultSet;
		}
		
		
		
		
		public static ResultSet getUserId() 
		{
			String sql = "";
			
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "select * from m_links";
				System.out.println(sql);
				resultSet = statement.executeQuery(sql);
			}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-getAdminProfile(int adminId): ");
				e.printStackTrace();
			}
			return resultSet;
		}
		
}