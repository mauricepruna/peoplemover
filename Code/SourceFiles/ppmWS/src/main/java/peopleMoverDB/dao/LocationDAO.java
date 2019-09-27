package peopleMoverDB.dao;

import java.text.ParseException;
import java.util.List;

import peopleMoverWS.model.Location;

public interface LocationDAO {
	//CRUD operations
    
    //Create
    public int save(Location location) throws ParseException;
    //Read
    public Location getByUnitIDAndDateTime(String unitID, String dateTime);
    //Update
    public int update(Location location);
    //Delete
    public int deleteByUnitID(String unitID);
    //Get All
    public List<Location> getAll();
}
