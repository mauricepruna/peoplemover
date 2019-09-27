package peopleMoverDB.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import peopleMoverWS.model.Location;
import peopleMoverWS.model.Unit;

public class UnitDAOImpl implements UnitDAO{
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	public int save(Unit unit) throws ParseException
    {
		String query = "insert into Units (ID,UnitID,LicencePlate,ShortName,Description,SerialNumber,IMEI,Address,City,State,"
				+ "CountryCode,PostalCode,LastEventCode,EventName,LastEventDate,LastLatitude,LastLongitude,Speed,Direction,"
				+ "DealerID,CompanyID,ContactName,IconPath,AssignedDriver,DriverID,LocalLastEventDatetxt ) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Object[] args = new Object[]{unit.getID(),unit.getUnitID(),unit.getLicencePlate(),unit.getShortName(),unit.getDescription(),unit.getSerialNumber(),unit.getIMEI(),
				unit.getAddress(),unit.getCity(),unit.getState(),unit.getCountryCode(),unit.getPostalCode(),unit.getLastEventCode(),unit.getEventName(),
				inputFormat.parse(unit.getLastEventDate()),
				unit.getLastLatitude(),unit.getLastLongitude(),unit.getSpeed(),unit.getDirection(),unit.getDealerID(),unit.getCompanyID(),unit.getContactName(),
				unit.getIconPath(),unit.getAssignedDriver(),unit.getDriverID(),unit.getLocalLastEventDatetxt()};
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
    public Unit getByID(String ID)
    {

		String query = "select ID,UnitID,LicencePlate,ShortName,Description,SerialNumber,IMEI,Address,City,State,"
				+ "CountryCode,PostalCode,LastEventCode,EventName,LastEventDate,LastLatitude,LastLongitude,Speed,Direction,"
				+ "DealerID,CompanyID,ContactName,IconPath,AssignedDriver,DriverID,LocalLastEventDatetxt from Units where ID= ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Unit unit = jdbcTemplate.queryForObject(query,new Object[]{ID}, new RowMapper<Unit>(){
			@Override
			public Unit mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Unit unit = new Unit();
				unit.setID(rs.getString("ID"));
				unit.setUnitID(rs.getString("UnitID"));
				unit.setLicencePlate(rs.getString("LicencePlate"));
				unit.setShortName(rs.getString("ShortName"));
				unit.setDescription(rs.getString("Description"));
				unit.setSerialNumber(rs.getString("SerialNumber"));
				unit.setIMEI(rs.getString("IMEI"));
				unit.setAddress(rs.getString("Address"));
				unit.setCity(rs.getString("City"));
				unit.setState(rs.getString("State"));
				unit.setCountryCode(rs.getString("CountryCode"));
				unit.setPostalCode(rs.getString("PostalCode"));
				unit.setLastEventCode(rs.getString("LastEventCode"));
				unit.setEventName(rs.getString("EventName"));
				unit.setLastEventDate(rs.getString("LastEventDate"));
				unit.setLastLatitude(rs.getString("LastLatitude"));
				unit.setLastLongitude(rs.getString("LastLongitude"));
				unit.setSpeed(rs.getString("Speed"));
				unit.setDirection(rs.getString("Direction"));
				unit.setDealerID(rs.getString("DealerID"));
				unit.setCompanyID(rs.getString("CompanyID"));
				unit.setContactName(rs.getString("ContactName"));
				unit.setIconPath(rs.getString("IconPath"));
				unit.setAssignedDriver(rs.getString("AssignedDriver"));
				unit.setDriverID(rs.getString("DriverID"));
				unit.setLocalLastEventDatetxt(rs.getString("LocalLastEventDatetxt"));
				return unit;
			}
			
		});
		return unit;
    }
	//Update
		@Override
	    public int update(Unit unit)
	    {
//			String query = "update Location set email=?, password=? where token=?";
//			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//			Object[] args = new Object[] {user.getEmail(), user.getPassword(), user.getToken()};
//			
//			int out = jdbcTemplate.update(query, args);
			int out = 0;
			return out;
	    }
		//Delete
		@Override
	    public int deleteByID(String ID)
	    {

			String query = "delete from Units where ID=?";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			
			int out = jdbcTemplate.update(query,ID);
			return out;
	    }
		//Get All
		@Override
	    public List<Unit> getAll()
	    {
			String query = "select * from Units";
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Unit> unitList = new ArrayList<Unit>();

			List<Map<String,Object>> UnitRows = jdbcTemplate.queryForList(query);
			
			for(Map<String,Object> UnitRow : UnitRows){
				Unit unit = new Unit();
				unit.setID(String.valueOf(UnitRow.get("ID")));
				unit.setUnitID(String.valueOf(UnitRow.get("UnitID")));
				unit.setLicencePlate(String.valueOf(UnitRow.get("LicencePlate")));
				unit.setShortName(String.valueOf(UnitRow.get("ShortName")));
				unit.setDescription(String.valueOf(UnitRow.get("Description")));
				unit.setSerialNumber(String.valueOf(UnitRow.get("SerialNumber")));
				unit.setIMEI(String.valueOf(UnitRow.get("IMEI")));
				unit.setAddress(String.valueOf(UnitRow.get("Address")));
				unit.setCity(String.valueOf(UnitRow.get("City")));
				unit.setState(String.valueOf(UnitRow.get("State")));
				unit.setCountryCode(String.valueOf(UnitRow.get("CountryCode")));
				unit.setPostalCode(String.valueOf(UnitRow.get("PostalCode")));
				unit.setLastEventCode(String.valueOf(UnitRow.get("LastEventCode")));
				unit.setEventName(String.valueOf(UnitRow.get("EventName")));
				unit.setLastEventDate(String.valueOf(UnitRow.get("LastEventDate")));
				unit.setLastLatitude(String.valueOf(UnitRow.get("LastLatitude")));
				unit.setLastLongitude(String.valueOf(UnitRow.get("LastLongitude")));
				unit.setSpeed(String.valueOf(UnitRow.get("Speed")));
				unit.setDirection(String.valueOf(UnitRow.get("Direction")));
				unit.setDealerID(String.valueOf(UnitRow.get("DealerID")));
				unit.setCompanyID(String.valueOf(UnitRow.get("CompanyID")));
				unit.setContactName(String.valueOf(UnitRow.get("ContactName")));
				unit.setIconPath(String.valueOf(UnitRow.get("IconPath")));
				unit.setAssignedDriver(String.valueOf(UnitRow.get("AssignedDriver")));
				unit.setDriverID(String.valueOf(UnitRow.get("DriverID")));
				unit.setLocalLastEventDatetxt(String.valueOf(UnitRow.get("LocalLastEventDatetxt")));
				unitList.add(unit);
			}
			return unitList;
	    }
}
