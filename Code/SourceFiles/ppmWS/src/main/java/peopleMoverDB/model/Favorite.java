package peopleMoverDB.model;

public class Favorite {
private String userToken;
private String stopId;
private String routeId;
private String emailFlag;
private String time;
public String getUserToken() {
	return userToken;
}
public void setUserToken(String userToken) {
	this.userToken = userToken;
}
public String getStopId() {
	return stopId;
}
public void setStopId(String stopId) {
	this.stopId = stopId;
}
public String getRouteId() {
	return routeId;
}
public void setRouteId(String routeId) {
	this.routeId = routeId;
}
public String getEmailFlag() {
	return emailFlag;
}
public void setEmailFlag(String emailFlag) {
	this.emailFlag = emailFlag;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}

}
