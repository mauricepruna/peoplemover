package peopleMoverDB.dao;

import java.text.ParseException;
import java.util.List;

import peopleMoverDB.model.Stops;

public interface StopTimesDAO {

    public List<Stops> getListByRouteID(String RouteId, String ID);
}