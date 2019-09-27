package peopleMoverDB.dao;

import java.util.List;

import peopleMoverDB.model.WayPoints;

public interface WayPointsAfterDAO {

	public List<WayPoints> getListByRouteANDStop(String StopId, String Route, String Latitude, String Longitude);
}
