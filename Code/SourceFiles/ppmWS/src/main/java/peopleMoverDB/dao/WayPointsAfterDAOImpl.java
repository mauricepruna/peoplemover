package peopleMoverDB.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import peopleMoverDB.model.Stops;
import peopleMoverDB.model.WayPoints;
import peopleMoverWS.model.Location;

public class WayPointsAfterDAOImpl implements WayPointsAfterDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	public List<WayPoints> getListByRouteANDStop(String StopId, String RouteId, String Latitude, String Longitude)
	{
		String query = "select * from Waypoints WHERE StopID < ? and RouteID =? and Wayorder >= (SELECT Wayorder from Waypoints where Latitude =? and Longitude=? and RouteID=? LIMIT 1)";
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	List<WayPoints> waypointlist = new ArrayList<WayPoints>();
    	
    	List<Map<String,Object>> waypointsRow = jdbcTemplate.queryForList(query,new Object[]{StopId,RouteId,Latitude, Longitude,RouteId});
    	for(Map<String,Object> waypointRow : waypointsRow){
    		WayPoints waypoint = new WayPoints();
        	waypoint.setWayID(String.valueOf(waypointRow.get("ID")));
        	waypoint.setStopId(String.valueOf(waypointRow.get("StopID")));
        	waypoint.setRouteId(String.valueOf(waypointRow.get("RouteID")));
        	waypoint.setLatitude(String.valueOf(waypointRow.get("Latitude")));
        	waypoint.setLongitude(String.valueOf(waypointRow.get("Longitude")));
        	waypoint.setWayorder(String.valueOf(waypointRow.get("Wayorder")));
        	waypointlist.add(waypoint);
    		
    	}

    	return waypointlist;
		
	}
	
}
