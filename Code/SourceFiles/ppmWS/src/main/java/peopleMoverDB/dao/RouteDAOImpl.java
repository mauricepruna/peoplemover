package peopleMoverDB.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import peopleMoverDB.model.Route;


public class RouteDAOImpl implements RouteDAO{
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	public Route getByRouteID(String RouteId)
	{
		String query = "select RouteID,Name,CreatedOn from Route where RouteID=?";
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	Route route = new Route();
		try{
			route = jdbcTemplate.queryForObject(query,new Object[]{RouteId}, new RowMapper<Route>()
			{
				@Override
				public Route mapRow(ResultSet rs,int rowsNum) throws SQLException
				{
					Route route  = new Route();
					route.setRouteId(rs.getString("RouteID"));
					route.setName(rs.getString("Name"));
					route.setCreatedOn(rs.getString("CreatedOn"));
					
					
					return route;
				
				}
			});
		}
		catch(DataAccessException e){
					
					e.printStackTrace();
				}
		return route;
	}
}
