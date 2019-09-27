package peopleMoverDB.model;



public class Stops {
private String StopId;
private String RouteId;
private String Street;
private String ScheduledTime;
private String Wayorder;
public String getWayorder() {
	return Wayorder;
}
public void setWayorder(String wayorder) {
	Wayorder = wayorder;
}
public String getLatitude() {
	return Latitude;
}
public void setLatitude(String latitude) {
	Latitude = latitude;
}
public String getLongitude() {
	return Longitude;
}
public void setLongitude(String longitude) {
	Longitude = longitude;
}
private String Latitude;
private String Longitude;


public String getStopId() {
	return StopId;
}
public void setStopId(String stopId) {
	StopId = stopId;
}
public String getRouteId() {
	return RouteId;
}
public void setRouteId(String routeId) {
	RouteId = routeId;
}
public String getStreet() {
	return Street;
}
public void setStreet(String street) {
	Street = street;
}
public String getScheduledTime() {
	return ScheduledTime;
}
public void setScheduledTime(String schedTime) {
	ScheduledTime = schedTime;
}

}
