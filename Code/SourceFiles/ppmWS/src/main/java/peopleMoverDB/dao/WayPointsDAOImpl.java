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

public class WayPointsDAOImpl implements WayPointsDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	public List<WayPoints> getListByRouteANDStop(String StopId, String RouteId)
	{
		String query = "select * from Waypoints where StopID=? and RouteID=?";
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	List<WayPoints> waypointlist = new ArrayList<WayPoints>();
    	
    	List<Map<String,Object>> waypointsRow = jdbcTemplate.queryForList(query,new Object[]{StopId,RouteId});
    	for(Map<String,Object> waypointRow : waypointsRow){
    		WayPoints waypoint = new WayPoints();
        	waypoint.setWayID(String.valueOf(waypointRow.get("ID")));
        	waypoint.setStopId(String.valueOf(waypointRow.get("StopID")));
        	waypoint.setRouteId(String.valueOf(waypointRow.get("RouteID")));
        	waypoint.setLatitude(String.valueOf(waypointRow.get("Latitude")));
        	waypoint.setLongitude(String.valueOf(waypointRow.get("Longitude")));
        	waypointlist.add(waypoint);
    		
    	}
//    	params.put("StopID", StopId);
//    	params.put("RouteID",RouteId);
//    	List<Map<String,Object>> wayRows = jdbcTemplate.queryForList(query,params);
//    	
//    	for(Map<String,Object> wayRow : wayRows){
//    	WayPoints waypoint = new WayPoints();
//    	waypoint.setWayID(String.valueOf(wayRow.get("ID")));
//    	waypoint.setStopId(String.valueOf(wayRow.get("StopID")));
//    	waypoint.setRouteId(String.valueOf(wayRow.get("RouteID")));
//    	waypoint.setLatitude(String.valueOf(wayRow.get("Latitude")));
//    	waypoint.setLongitude(String.valueOf(wayRow.get("Longitude")));
//    	waylist.add(waypoint);
//    	}
    	return waypointlist;
		
	}
	
}
