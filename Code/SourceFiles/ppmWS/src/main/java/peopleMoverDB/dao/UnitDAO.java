package peopleMoverDB.dao;

import java.text.ParseException;
import java.util.List;

import peopleMoverWS.model.Unit;

public interface UnitDAO {
//CRUD operations
    
    //Create
    public int save(Unit unit) throws ParseException;
    //Read
    public Unit getByID(String ID);
    //Update
    public int update(Unit unit);
    //Delete
    public int deleteByID(String ID);
    //Get All
    public List<Unit> getAll();
}
