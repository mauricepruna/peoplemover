package peopleMoverDB.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import peopleMoverDB.model.User;

public class UserDAOImpl implements UserDAO{
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	@Override
	public int save(User user)
	{
		String query = "insert into User (token,email,password,admin) values (?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[]{user.getToken(),user.getEmail(),user.getPassword(),user.getIsadmin()};
		int out;
		try{
		 out = jdbcTemplate.update(query,args);
		}catch(DataAccessException e)
		{
			e.printStackTrace();
			out = 0;
		}
		
		return out;
//		if(out!=0)
//		{
//			 System.out.println("User saved with id="+user.getToken());
//        }else System.out.println("User save failed with id="+user.getToken());
		
	}
	@Override
	public User getByToken(String token)
	{
		String query = "select token, email, password, admin from User where token= ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		User user = jdbcTemplate.queryForObject(query,new Object[]{token}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				User user = new User();
				user.setToken(rs.getString("token"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setIsadmin(rs.getString("admin"));
				return user;
			}
			
		});
		return user;
	}
	@Override
	public User getByEmail(String email,String pass)
	{
		String query = "select token, email, password, admin from User where email= ? and password=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		User user;
		try {
			user = jdbcTemplate.queryForObject(query,new Object[]{email,pass}, new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					User user = new User();
				
					
						user.setToken(rs.getString("token"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
						user.setIsadmin(rs.getString("admin"));
					
					
					return user;
				}
				
			});
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			user = new User();
			user.setToken("");
		}
		
		return user;
	}
//	@Override
//	public int update(User user) {
//		String query = "update User set email=?, password=? where token=?";
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		Object[] args = new Object[] {user.getEmail(), user.getPassword(), user.getToken()};
//		
//		int out = jdbcTemplate.update(query, args);
//		return out;
////		if(out !=0){
////			System.out.println("User updated with id="+user.getToken());
////		}else System.out.println("No User found with id="+user.getToken());
//	}
	@Override
	public int deleteByToken(String token) {

		String query = "delete from User where token=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query,token);
		return out;
//		if(out !=0){
//			System.out.println("User deleted with id="+token);
//		}else System.out.println("No User found with id="+token);
	}
	@Override
	public List<User> getAll() {
		String query = "select token, email, password, admin from User";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> userList = new ArrayList<User>();

		List<Map<String,Object>> userRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> userRow : userRows){
			User user = new User();
			user.setToken(String.valueOf(userRow.get("token")));
			user.setEmail(String.valueOf(userRow.get("email")));
			user.setPassword(String.valueOf(userRow.get("password")));
			user.setIsadmin(String.valueOf(userRow.get("admin")));
			userList.add(user);
		}
		return userList;
	}
}
