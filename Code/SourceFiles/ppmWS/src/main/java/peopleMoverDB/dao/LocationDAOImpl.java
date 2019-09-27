package peopleMoverDB.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import peopleMoverWS.model.Location;

public class LocationDAOImpl implements LocationDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	@Override
	public int save(Location location) throws ParseException
    {
String query = "insert into Location (UnitID,LastEventDate,Address,City,State, PostalCode, CountryCode, Latitude, Longitude, Heading, InsertionTime ) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		Object[] args = new Object[]{location.getUnitID(),inputFormat.parse(location.getLastEventDate()),location.getAddress(),location.getCity(),location.getState(),location.getPostalCode(),location.getCountryCode(),
									location.getLatitude(),location.getLongitude(),location.getHeading(),new Date()};
		int out;
		try{
		 out = jdbcTemplate.update(query,args);
		}catch(DataAccessException e)
		{
			e.printStackTrace();
			out = 0;
		}
		
		return out;
    }
    //Read
	@Override
    public Location getByUnitIDAndDateTime(String UnitID, String dateTime)
    {

		String query = "select UnitID,LastEventDate,Address,City,State, PostalCode, CountryCode, Latitude, Longitude,Heading from Location where UnitID= ? and LastEventDate= ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Location location = jdbcTemplate.queryForObject(query,new Object[]{UnitID,dateTime}, new RowMapper<Location>(){
			@Override
			public Location mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Location loc = new Location(rs.getString("UnitID"));
				loc.setLastEventDate(rs.getString("LastEventDate"));
				loc.setAddress(rs.getString("Address"));
				loc.setCity(rs.getString("City"));
				loc.setState(rs.getString("State"));
				loc.setPostalCode(rs.getString("PostalCode"));
				loc.setCountryCode(rs.getString("CountryCode"));
				loc.setLatitude(rs.getString("Latitude"));
				loc.setLongitude(rs.getString("Longitude"));				
				loc.setHeading(rs.getString("Heading"));
				return loc;
			}
			
		});
		return location;
    }
    //Update
	@Override
    public int update(Location location)
    {
//		String query = "update Location set email=?, password=? where token=?";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		Object[] args = new Object[] {user.getEmail(), user.getPassword(), user.getToken()};
//		
//		int out = jdbcTemplate.update(query, args);
		int out = 0;
		return out;
    }
    //Delete
	@Override
    public int deleteByUnitID(String unitID)
    {

		String query = "delete from Location where unitID=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query,unitID);
		return out;
    }
    //Get All
	@Override
    public List<Location> getAll()
    {
		String query = "select * from Location";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Location> locationList = new ArrayList<Location>();

		List<Map<String,Object>> LocationRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> locationRow : LocationRows){
			Location loc = new Location(String.valueOf(locationRow.get("UnitID")));
			loc.setAddress(String.valueOf(locationRow.get("Address")));
			loc.setCity(String.valueOf(locationRow.get("City")));
			loc.setLatitude(String.valueOf(locationRow.get("Latitude")));
			loc.setLongitude(String.valueOf(locationRow.get("Longitude")));
			loc.setLastEventDate(String.valueOf(locationRow.get("LastEventDate")));
			locationList.add(loc);
		}
		return locationList;
    }
}
