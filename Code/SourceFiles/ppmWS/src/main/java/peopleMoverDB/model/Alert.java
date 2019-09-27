package peopleMoverDB.model;

public class Alert {
private String alertid;
public String getAlertid() {
	return alertid;
}
public void setAlertid(String alertid) {
	this.alertid = alertid;
}
private String token;
private String message;
private String insertiontime;
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getInsertiontime() {
	return insertiontime;
}
public void setInsertiontime(String insertiontime) {
	this.insertiontime = insertiontime;
}


}
