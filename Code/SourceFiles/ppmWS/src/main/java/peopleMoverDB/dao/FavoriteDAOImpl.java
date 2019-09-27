package peopleMoverDB.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import peopleMoverDB.model.Favorite;

public class FavoriteDAOImpl implements FavoriteDAO{
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	//Create
	@Override
	public int save(Favorite fav)
	{
		String query = "INSERT INTO FavoriteStops (User_token,Stops_ID,Stops_RouteID,email_flag,DefinedTime) VALUES(?,?,?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[]{fav.getUserToken(),fav.getStopId(),fav.getRouteId(),fav.getEmailFlag(),fav.getTime()};
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
	public Favorite getFavorite(String token,String StopId, String RouteId)
	{
		String query = "SELECT User_token,Stops_ID,Stops_RouteID,email_flag,DefinedTime FROM FavoriteStops "
				+ "WHERE User_token=? AND Stops_ID=? AND Stops_RouteID=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Favorite fav;
		try{
			fav = jdbcTemplate.queryForObject(query,new Object[]{token,StopId,RouteId}, new RowMapper<Favorite>()
			{
				@Override
				public Favorite mapRow(ResultSet rs,int rowsNum) throws SQLException
				{
					Favorite fav = new Favorite();
					fav.setUserToken(rs.getString("User_token"));
					fav.setStopId(rs.getString("Stops_ID"));
					fav.setRouteId(rs.getString("Stops_RouteID"));
					fav.setTime(rs.getString("DefinedTime"));
					fav.setEmailFlag(rs.getString("email_flag"));
					
					return fav;
				}
			});
		}
		catch(DataAccessException e){
			
			e.printStackTrace();
			fav = new Favorite();
			fav.setUserToken("");
		}
		return fav;
	}
	//Update
	@Override
	public int update(Favorite fav) {
		String query = "UPDATE  FavoriteStops Set email_flag=?, DefinedTime=? WHERE User_token=? AND Stops_ID=? AND Stops_RouteID=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {fav.getEmailFlag(),fav.getTime(),fav.getUserToken(),fav.getStopId(),fav.getRouteId()};
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
	//Delete
	@Override
	public int deleteFavorite(String token,String StopId, String RouteId)
	{
		String query = "DELETE FROM FavoriteStops WHERE User_token=? AND Stops_ID=? AND Stops_RouteID=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {token,StopId,RouteId};
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
	//GET ALL
	@Override
	public List<Favorite> getAll()
	{
		String query = "SELECT * FROM FavoriteStops";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Favorite> listfav = new ArrayList<Favorite>();
		List<Map<String,Object>> favRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> favRow : favRows){
			Favorite fav = new Favorite();
			fav.setUserToken(String.valueOf(favRow.get("User_token")));
			fav.setStopId(String.valueOf(favRow.get("Stops_ID")));
			fav.setRouteId(String.valueOf(favRow.get("Stops_RouteID")));
			fav.setEmailFlag(String.valueOf(favRow.get("email_flag")));
			fav.setTime(String.valueOf(favRow.get("DefinedTime")));
			listfav.add(fav);
			
		}
		return listfav;
		
	}
	@Override
	public List<Favorite> getAll(String token)
	{
		String query = "SELECT * FROM FavoriteStops WHERE User_token=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {token};
		List<Favorite> listfav = new ArrayList<Favorite>();
		List<Map<String,Object>> favRows = jdbcTemplate.queryForList(query,args);
		
		for(Map<String,Object> favRow : favRows){
			Favorite fav = new Favorite();
			fav.setUserToken(String.valueOf(favRow.get("User_token")));
			fav.setStopId(String.valueOf(favRow.get("Stops_ID")));
			fav.setRouteId(String.valueOf(favRow.get("Stops_RouteID")));
			fav.setEmailFlag(String.valueOf(favRow.get("email_flag")));
			fav.setTime(String.valueOf(favRow.get("DefinedTime")));
			listfav.add(fav);
			
		}
		return listfav;
		
	}
}

