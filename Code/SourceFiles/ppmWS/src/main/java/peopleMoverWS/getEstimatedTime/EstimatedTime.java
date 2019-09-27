package peopleMoverWS.getEstimatedTime;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverDB.dao.StopTimesDAO;
import peopleMoverDB.dao.StopsDAO;
import peopleMoverDB.dao.WayPointsAfterDAO;
import peopleMoverDB.model.Stops;
import peopleMoverDB.model.WayPoints;
import peopleMoverWS.controller.StopController;
import peopleMoverWS.controller.UnitListController;
import peopleMoverWS.model.FormattedMessage;
import peopleMoverWS.model.Unit;
@RestController
public class EstimatedTime {
	
	@RequestMapping("/getTimes")
	public FormattedMessage getStops(@RequestParam(value="RouteId", required=true) String RouteId, @RequestParam(value="StopId", required=true) String StopId) 
	{
		FormattedMessage stopList = getStopsCx(RouteId, StopId);
		return stopList ;
	}
	private FormattedMessage getStopsCx(String RouteId, String StopId)
	{
		//Get the Spring Context
		FormattedMessage fMessage = new FormattedMessage();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//To use JdbcTemplate
		StopTimesDAO stopTimesDAO = ctx.getBean("StopTimesDAOJDBCTemplate", StopTimesDAO.class);
		List<Stops> liststop = stopTimesDAO.getListByRouteID(RouteId, StopId);
		if(liststop.size()-1 > 0){
			String route = liststop.get(liststop.size()-1).getRouteId();
			String stop = liststop.get(liststop.size()-1).getStopId();
			String lat = liststop.get(liststop.size()-1).getLatitude();
			String lon = liststop.get(liststop.size()-1).getLongitude();
			//System.out.println("lat is " + lat);
			//System.out.println("lat is " + lon);
			String result = getEstimatedTime(liststop, route, stop, lat, lon);
			fMessage.setCode("1");
			fMessage.setMessage(result);
		}else{
			fMessage.setCode("1");
			fMessage.setMessage("N/A");
		}
		
		return fMessage;
	}
	
	private String getEstimatedTime(List<Stops> liststop, String route, String stop, String lat, String lon) {
		double totalDistance = 0.0 ;
		String result;
		boolean foundWaypoint = false;
		StopController stopInfo = new StopController();
		UnitListController test = new UnitListController();
		String testSpeed = "30";
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		StopsDAO stopsDAO = ctx.getBean("StopsDAOJDBCTemplate", StopsDAO.class);
		List<Stops> targetStp = stopsDAO.getListByRouteID(route);
		
		List<Stops> stopsInfo = new ArrayList<Stops>();
		
		//System.out.println("Stop = "+ stop);

		//System.out.pritnln
		
		for(int k = 0; k < stopInfo.getStops(route).size()-1; k++){
			//ignoring first stop
			
			stopsInfo.add((Stops) stopInfo.getStops(route).get(k+1));
			
		}
		
//		List<Unit> uList = new ArrayList<Unit>();
//		uList.add((Unit) test.getunitlist().get(0));
//		uList.add((Unit) test.getunitlist().get(1));
//				
//		// here we get the last position of each bus
//		for(Unit temp : uList){
//			   System.out.println("latitude = " + temp.getLastLatitude()); 
//			   System.out.println("longitude = " + temp.getLastLongitude());
//			   //estimateDistance(temp.getLastLatitude(), temp.getLastLongitude());
//			   
//			}
		
		//25.6684025323
		for(Stops latlon : stopsInfo){
//			System.out.println(latlon.getLatitude() + "," + latlon.getLongitude());
//			System.out.println(lat);
//			System.out.println(lon);
			
			if(latlon.getLatitude().equals(lat) && latlon.getLongitude().equals(lon)){
				//System.out.println("we are in");
				
				for(int i = 0; i < liststop.size()-1; i++){
					String waypointLat = liststop.get(i).getLatitude();
					String waypointLon = liststop.get(i).getLongitude();
					String testLat = "25.662998";
					String testLon = "-80.323429";
					
					
					//System.out.println(latlon.getLatitude() + "," + latlon.getLongitude() );
					String[] holder = compareDistance(testLat, testLon, waypointLat, waypointLon, latlon.getLatitude(), latlon.getLongitude());
					if(holder[0].equals("waypoint") ){
						String wayorder = liststop.get(i).getWayorder();
//						System.out.println("Wayorder is" + liststop.get(i).getWayorder());
//						System.out.println("Route is" + liststop.get(i).getRouteId());						
//						System.out.println("holders: " + holder[1] + "," + holder[2]);
						totalDistance = getDistance( route, targetStp.get(Integer.parseInt(stop)).getStopId(), holder[1], holder[2], wayorder);
						foundWaypoint = true;
						break;
					}
					
				}
				if(latlon.getLatitude().equals(liststop.get(liststop.size()-1).getLatitude()) || foundWaypoint)
						break;
				
			}
			
			
		}
		
		
		double speed = Double.parseDouble(testSpeed);
		
		double time = totalDistance/speed;
		String showTime;
		
		DecimalFormat formatter = new DecimalFormat("##");
		
		if(totalDistance == 0.0){
			result = "N/A";
			//System.out.println(result);
			return result;
		}else if((time*60*60) < 60)
		{
			int finalSec = (int) Math.round((time*60*60));
			showTime = formatter.format(finalSec);
			result = "00:00:" + showTime;
			//System.out.println(result);
			return result;
		}else if((time*60) < 60)
		{
			if(time*60*60< 60){
				double finalSec = (double) Math.round((time*60*60)-60);
				double finalMin = (double) Math.round(time*60);
				String temp = Double.toString(finalSec);
				String temp1 = Double.toString(finalMin);
				
				String showSec = formatter.format(finalSec);
				String showMin = formatter.format(finalMin);
				result = "00:"+ temp1.substring(0,2) +  ":" + temp.substring(0,2);
			}
			
			double finalSec = (double) Math.round((time*60*60));
			double finalMin = (double) Math.round(time*60);
			String temp = Double.toString(finalSec);
			String temp1 = Double.toString(finalMin);
			
			String showSec = formatter.format(finalSec);
			String showMin = formatter.format(finalMin);
			if(showMin.length() == 1 )
			{
				result = "00:"+ "0" +temp1.substring(0,1) +  ":" + temp.substring(0,2);
			}else{
				result = "00:"+ temp1.substring(0,2) +  ":" + temp.substring(0,2);
			}

			//System.out.println(result);
			return result;
		}else{
			
			result = "" + (int) (Math.round(time*60)) + ":" + (int) Math.round((time*60)) + ":"+ (int) Math.round((time*60*60));
			//System.out.println(result);
			return result;
		}

		
		
//		liststopWP.add((StopsWithWP) stops.getStopWayPoints(route).get(Integer.parseInt(stop)-1));
////			
//		for(StopsWithWP temp1 : liststopWP){
//			int m = 0;
//			while( m < temp1.getListwp().size()){
//				String waypointLat = temp1.getListwp().get(m).getLatitude();
//				String waypointLon = temp1.getListwp().get(m).getLongitude();
//				
////			System.out.println(temp1.getListwp().get(m).getLatitude());
////			System.out.println(temp1.getListwp().get(m).getLongitude());
////			System.out.println(temp1.getStopId());
//			String testLat = "25.659780";
//			String testLon = "-80.324834";
//			//System.out.println("testlat: " + testLat);
//			
//			//System.out.println(waypointLat);
//			
//			//estimateDistance(testLat, testLon, waypointLat, waypointLon, lat, lon);
//				m++;
//			}
//		}
		
		
	
		
	}

	
	private double getDistance( String route, String stop ,String lat, String lon, String wayorder ) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		WayPointsAfterDAO WayPointsAfterDAO = ctx.getBean("WayPointsAfterDAOJDBCTemplate", WayPointsAfterDAO.class);
		List<WayPoints> wpList = WayPointsAfterDAO.getListByRouteANDStop(stop, route, lat, lon);
		
		double distance = 0.0;
//		if(wpList.size() <= 1){
//			System.out.println("we read that the size is 0 for waypoints");
//			return 0.0;
//		}
		
		for(int i = 0; i < wpList.size()-1; i++){
			double lat1 = Double.parseDouble(wpList.get(i).getLatitude());
			double lon1 = Double.parseDouble(wpList.get(i).getLongitude());
			double lat2 = Double.parseDouble(wpList.get(i+1).getLatitude());
			double lon2 = Double.parseDouble(wpList.get(i+1).getLongitude());
			
//			System.out.println("dist lat = "+ lat1);
//			System.out.println("dist lon = "+ lon1);
//			System.out.println("dist lat2 = "+ lat2);
//			System.out.println("dist lon2 = "+ lon2);
			
			double theta = lon1 - lon2;
		    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		    dist = Math.acos(dist);
		    dist = rad2deg(dist);
			dist = dist * 60 * 1.1515;
			
			if(lat1 != lat2 && lon1 != lon2){			
				distance += dist;			
			}

		}

		
		return distance;
	}
	
	private String[] compareDistance(String trolleyLat, String trolleyLon, String wpLat, String wpLon, String stopLat, String stopLon)
	{

			double lat1 = Double.parseDouble(trolleyLat);
			double lon1 = Double.parseDouble(trolleyLon);
			double lat2 = Double.parseDouble(wpLat);
			double lon2 = Double.parseDouble(wpLon);
			double latStop = Double.parseDouble(stopLat);
			double lonStop = Double.parseDouble(stopLon);
			
			
			double theta = lon1 - lonStop;
			double theta1 = lon2 - lonStop;
		    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(latStop)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(latStop)) * Math.cos(deg2rad(theta));
		    dist = Math.acos(dist);
		    dist = rad2deg(dist);
			dist = dist * 60 * 1.1515;
			
			double dist1 = Math.sin(deg2rad(lat2)) * Math.sin(deg2rad(latStop)) + Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(latStop)) * Math.cos(deg2rad(theta1));
		    dist1 = Math.acos(dist1);
		    dist1 = rad2deg(dist1);
			dist1 = dist1 * 60 * 1.1515;
//			System.out.println("dist = "+ dist);
//			System.out.println("dist1 = "+ dist1);

		if(Math.abs(dist - dist1) < 0.01)
		{
			//System.out.println("Same distance");
			return new String[]{"Close enough"};
		}
		else if(dist < dist1)
		{
			//System.out.println("trolley is closer");
			return new String[]{"trolley", trolleyLat, trolleyLon};
		}else if(dist1 < dist)
		{
//			System.out.println("waypoint is closer");
//			System.out.println(wpLat);
			return new String[]{"waypoint", wpLat, wpLon};
		}else{
			//System.out.println("same distance");
			return new String[]{"same distance"};
		}
	}
	
	private double deg2rad(double degree){
		return degree * (Math.PI/180);
	}
	
	private double rad2deg(double rad) {
	      return (rad * 180.0 / Math.PI);
	    }
}