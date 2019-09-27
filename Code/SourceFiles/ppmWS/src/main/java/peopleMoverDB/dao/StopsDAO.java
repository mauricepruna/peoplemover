package peopleMoverDB.dao;


import java.util.List;

import peopleMoverDB.model.Stops;

public interface StopsDAO {

	//CRUD operations
    
//    //Create
//    public int save(Stops stop) throws ParseException;
//    //Read
    public Stops getByStopsAndRoute(String StopId, String RouteId);
//    //Update
//    public int update(Stops location);
//    //Delete
//    public int deleteByStopsID(String StopsID);
    //Get All
    public List<Stops> getListByRouteID(String RouteId);
}
