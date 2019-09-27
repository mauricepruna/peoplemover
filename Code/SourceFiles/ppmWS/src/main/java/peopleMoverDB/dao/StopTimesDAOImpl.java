package peopleMoverDB.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import peopleMoverDB.model.Stops;

public class StopTimesDAOImpl implements StopTimesDAO {

	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
    public List<Stops>  getListByRouteID(String RouteId, String StopId)
    {
    	String query = "SELECT * FROM Waypoints where RouteID=? and StopID <?";
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	List<Stops> stoplist = new ArrayList<Stops>();
    	List<Map<String,Object>> stopRows = jdbcTemplate.queryForList(query,RouteId, StopId);
    	
    	for(Map<String,Object> stopRow : stopRows){
    	Stops stop = new Stops();
    	stop.setStreet(String.valueOf(stopRow.get("Street")));
    	stop.setLatitude(String.valueOf(stopRow.get("Latitude")));
    	stop.setLongitude(String.valueOf(stopRow.get("Longitude")));
    	stop.setStopId(String.valueOf(stopRow.get("StopID")));
    	stop.setRouteId(String.valueOf(stopRow.get("RouteID")));
    	stop.setWayorder(String.valueOf(stopRow.get("Wayorder")));
    	stopRow.get(RouteId);
    	stoplist.add(stop);
    	}
    	return stoplist;
    	
    }

}
