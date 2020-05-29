

package com.dev.util;


public class Distance 
{

// 1.	
    /* Best Distance Calculation Formulla(Starts) */
	public static double distFrom(double lat1, double lng1, double lat2, double lng2) 
	{
		//double earthRadius = 3958.75;//In Miles
		//double earthRadius = 6371;//In Km(Kilo meteres)
		double earthRadius = 6371 * 1000;//In m(meter)
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	           Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	           Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    return   earthRadius * c;
   }
	
   /* Best Distance Calculation Formulla(Ends) */	
	
// 2.	
	
/*
 *  Passed to function:    
 *   lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees)  
 *   lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees)
 *   
 *  unit = the unit you desire for results   
 *  		where: 'M' is statute miles  
 *  		'K' is kilometers (default)  
 *  		'N' is nautical miles                                                           
*/
	
	public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) 
	{
	  double theta = lon1 - lon2;
	  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	  dist = Math.acos(dist);
	  dist = rad2deg(dist);
	  dist = dist * 60 * 1.1515;
	  
	  if (unit.equals("K")) 
	  {
	    dist = dist * 1.609344;
	  }
	  else if (unit.equals("N")) 
	  {
	  	dist = dist * 0.8684;
	  }
	  return (dist);
	}

	private static double deg2rad(double deg) 
	{
	  return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) 
	{
	  return (rad * 180 / Math.PI);
	}

/*
 * 	Test
 * system.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
 * system.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " Kilometers\n");
 * system.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
*/
	
	
// Testing The Development
	public static void main(String[] args)
	{
		double distance = 0;
		
		double lat1 = 12.916557;
		double lon1 = 77.610148;
		
/*		
		//Point1(Srouce-Same)
		double lat2 = 12.931818;
		double lon2= 77.583436;
*/		
		
	
/*		//Point2
		double lat2 = 12.931912;
		double lon2=  77.58345;
*/	
		
/*		//Point3
		double lat2 = 12.932816;
		double lon2= 77.583548;
*/		
		
		//Point4
		double lat2 = 12.931922;
		double lon2= 77.583531;
				
		
		//distance = Distance.getDistance(lat1, lon1, lat2, lon2);
		distance = Distance.distance(lat1, lon1, lat2, lon2, "K");
		System.out.println("Distance : " + distance);
		
	}
	
}
