package peopleMoverDB.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import peopleMoverDB.model.Alert;
import scala.Array;


public class AlertDAOImpl implements AlertDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	@Override
	public int save(Alert alert) {
		String query = "insert into Alert (User_token,Message,InsertionTime) values (?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		Object[] args = new Object[]{alert.getToken(),alert.getMessage(),new Date()};
		
		
		int out=jdbcTemplate.update(query,args);
		
		return out;
	}

//	@Override
//	public Alert getByToken(String token) {
//		String query = "select User_token,Message,InsertionTime from Alert where User_token= ?";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		Alert alert = jdbcTemplate.queryForObject(query,new Object[]{token}, new RowMapper<Alert>(){
//			@Override
//			public Alert mapRow(ResultSet rs, int rowNum) throws SQLException
//			{
//				Alert inAlert = new Alert();
//				inAlert.setToken(rs.getString("User_token"));
//				inAlert.setMessage(rs.getString("Message"));
//				inAlert.setInsertiontime(rs.getString("InsertionTime"));
//				return inAlert;
//			}
//		});
//		
//		return alert;
//	}

	@Override
	public int update(Alert alert) {
		String query = "update Alert set Message=?, InsertionTime=? where User_token=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {alert.getMessage(), new Date(), alert.getToken()};
		int out;
		
		 out = jdbcTemplate.update(query,args);
		
		return out;
	}
	@Override
	public List<Alert> getAll() {
		String query = "SELECT * FROM Alert ORDER BY InsertionTime DESC";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Alert> listalert = new ArrayList<Alert>();
		List<Map<String,Object>> alertsRows = jdbcTemplate.queryForList(query);
		for(Map<String,Object> alertRow : alertsRows){
			Alert alert = new Alert();
			alert.setToken(String.valueOf(alertRow.get("User_Token")));
			alert.setMessage(String.valueOf(alertRow.get("Message")));
			alert.setInsertiontime(String.valueOf(alertRow.get("InsertionTime")));
			listalert.add(alert);
			}
		return listalert;
	}
	
	

}
