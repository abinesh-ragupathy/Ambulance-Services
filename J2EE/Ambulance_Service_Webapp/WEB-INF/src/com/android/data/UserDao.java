package com.android.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dev.dao.DAO;
import com.dev.util.Distance;

public class UserDao {

	static boolean res = false;

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDao userDAO = null;

	

	private UserDao() {
	}

	public static UserDao initialize() {
		if (userDAO == null) {
			userDAO = new UserDao();
		}
		return userDAO;
	}

	public static String AddPassenger(String passengerid, String password,
			String userName, String userEmailId, String userPhone) {
		boolean flag = false;
		String res = "";
		int i = 0;
		try {
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select * from m_passenger where m_passengerid ='"
							+ passengerid + "' or m_email ='" + userEmailId + "' ");
			while (resultSet.next()) {
				flag = true;
			}

			if (flag == true) {
				res = "2";
			} else {
				String sql = "insert into m_passenger (m_passengerid,m_password,m_name,m_email,m_phone) values('"
						+ passengerid
						+ "', "
						+ "'"
						+ password
						+ "', '"
						+ userName
						+ "', '"
						+ userEmailId + "', '" + userPhone + "')";
				System.out.println(sql);
				i = statement.executeUpdate(sql);
				if (i != 0) {
					res = "1";
				}
				System.out.println("User register status (T/F) :-" + flag);
			}
		} catch (Exception e) {
			System.out
					.println("Exception in addZoneDetails-->Add(..........): "
							+ e);
		}
		return res;
	}

	public static boolean passengerLogin(String passengerid, String password) {
		String sql = "";
		boolean flag = false;
		try {
			connection = DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_passenger where m_passengerid='" + passengerid
					+ "' and m_password='" + password + "'";
			System.out.println("********** User Login Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				flag = true;
			}
			System.out.println("User Login Status : " + flag);
		} catch (Exception e) {
			System.out
					.println("Exception in UserDAO==>loginCheck(String passengerid,String password) : ");
			e.printStackTrace();
		}
		return flag;
	}

	public static List<String> getAlertMessage(String latitude, String longitude) {
		System.out.println("Inside getAlertMessage");
		List<String> list1 = new ArrayList<String>();
		double lati;
		double longi;
		String sql = "";
		ResultSet rs = null;

		String dbLatitude = "";
		String dbLongitude = "";
		String distance = "";
		String alertMessage = "";

		lati = Double.parseDouble(latitude);
		longi = Double.parseDouble(longitude);

		try {
			connection = DAO.getConnection();
			statement = connection.createStatement();
			sql = "select m_latitude,m_longitude,m_threshold_dist,alert_msg from m_accidentzoneinfo";
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			System.out.println(rs);

			while (rs.next()) {
				dbLatitude = rs.getString(1);
				dbLongitude = rs.getString(2);
				distance = rs.getString(3);
				alertMessage = rs.getString(4);

				double dis = Distance.distance(lati, longi,
						Double.parseDouble(dbLatitude),
						Double.parseDouble(dbLongitude), "K");
				System.out
						.println("~~~~~~~~~~~~~~~~~~~~~~dis~~~~~~~~~~~~~~~~~~~~~~~~ "
								+ String.valueOf(dis));

				if (dis < Double.parseDouble(distance) / 1000.0) {
					list1.add(alertMessage);
				}
			}

			System.out.println(dbLatitude + "~" + dbLongitude + "~" + distance
					+ "~" + alertMessage);

			System.out.println("----------list1----------" + list1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return list1;
	}

	public static String getAmbulancePhone(String latitude, String longitude) {
		System.out.println("getAmbulancePhone");
		boolean flag = false;
		String sql = "";
		String sql2 = "";
		ResultSet rs = null;
		String status = "Available";
		
		int i=0;
		
		ArrayList<String> list=new ArrayList<String>();
        ArrayList<String> list1=new ArrayList<String>();
        
        String smalldisnamephone = "";
        String smallCode = "";
		
		try {
			connection = DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from p_ambulance where status = '"+status+"'";
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			
			
			while (rs.next()) {
				//String name = rs.getString(2);
				String code = rs.getString(1);
				String phone = rs.getString(10);
				String lati = rs.getString(12);
				String langi = rs.getString(13);
				
				
				double distance = Distance.distance(Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(lati), Double.parseDouble(langi),"K");

				if (distance < 10.00) {
					
					list1.add(String.valueOf(distance));
					list.add(String.valueOf(distance)+"~"+lati+"~"+langi+"~"+phone+"~"+code);
					
				}
				
				Object obj = Collections.min(list1);
				
				for (int ii=0;ii<list.size();ii++)
				{
				  String value=   list.get(ii).toString();
				  String[] dataa =  value.split("~");

				 String dist= dataa[0];
				  if(dist.equals(obj.toString()))
				  {
				      String smalallat = dataa[1];
				      String smalllong = dataa[2];
				      smalldisnamephone = dataa[3];
				      smallCode = dataa[4];
				      
				  }
				}
			}
			System.out.println("========================list================================================================================  " + list);
			System.out.println("========================Ambulance Phone======================== " + smalldisnamephone + " ---- " + smallCode);
			
			sql2 = "update p_ambulance set status = '"+"Occupied"+"' where code = '"+smallCode+"'";
		    System.out.println(sql2);
		    int res = statement.executeUpdate(sql2);
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return smalldisnamephone;
	}
	
	public static String getHospitalLocations(String latitude, String longitude) {
		System.out.println("getHospitalLocations");
		boolean flag = false;
		String sql = "";
		ResultSet rs = null;
		
		int i=0;
		String data="";
		String lat = "";
		String lon = "";
		
		try {
			connection = DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from h_hospital";
			System.out.println(sql);
			rs = statement.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString(2);
				String phone = rs.getString(10);
				String lati = rs.getString(12);
				String langi = rs.getString(13);
				double distance = Distance.distance(Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(lati), Double.parseDouble(langi),"K");

				if (distance < 1.00) {
					if (i == 0) {
						data = phone;
						lat = lati;
						lon = langi;
						i++;
					}
				}
			}
			System.out.println("========================getHospitalLocations======================== " + data);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data+"~"+lat+"~"+lon;
	}
}
