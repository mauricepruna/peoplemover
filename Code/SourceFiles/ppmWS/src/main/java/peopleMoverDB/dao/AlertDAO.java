package peopleMoverDB.dao;

import java.text.ParseException;
import java.util.List;

import peopleMoverDB.model.Alert;

public interface AlertDAO {

//CRUD operations
    
    //Create
    public int save(Alert alert);
    //Read
//    public Alert getByToken(String token);
    //Update
    public int update(Alert alert);
    //Delete
    //public int deleteByToken(String token);
    //Get All
    public List<Alert> getAll();
}
