package peopleMoverDB.dao;

import peopleMoverDB.model.Route;

public interface RouteDAO {

	//CRUD operations
    
//  //Create
//  public int save(Stops stop) throws ParseException;
//  //Read
  public Route getByRouteID(String RouteId);
//  //Update
//  public int update(Stops location);
//  //Delete
//  public int deleteByStopsID(String StopsID);
  //Get All
  //public List<Stops> getListByRouteID(String RouteId);
}
