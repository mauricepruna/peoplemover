package peopleMoverDB.dao;
import java.util.List;
import peopleMoverDB.model.User;

public interface UserDAO {
	//CRUD operations
	     
	    //Create
	    public int save(User user);
	    //Read
	    public User getByToken(String token);
	    public User getByEmail(String email,String pass);
	    //Update
//	    public int update(User user);
	    //Delete
	    public int deleteByToken(String token);
	    //Get All
	    public List<User> getAll();
}