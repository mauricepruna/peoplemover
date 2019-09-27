package peopleMoverDB.dao;

import java.text.ParseException;
import java.util.List;

import peopleMoverDB.model.WayPoints;;

public interface WayPointsDAO {
//CRUD operations
    
//    //Create
//    public int save(WayPoints waypoint) throws ParseException;
//    //Read
//    public WayPoints getByWayId(String WayID);
//    //Update
//    public int update(WayPoints waypoint);
//    //Delete
//    public int deleteByWayId(String WayId);
//    //Get All
    public List<WayPoints> getListByRouteANDStop(String StopId, String Route);

}
