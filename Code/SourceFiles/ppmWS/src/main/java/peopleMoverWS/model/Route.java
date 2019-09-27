package peopleMoverWS.model;



public class Route {
    
    String WatcherId;
    String RouteId;
    String UnitID;
    String ScheduledDate;
    String ActivatedOn;
    String LastStopID;
    String ClosedOn;
    String CreatedOn;
    String StatusRoute;

    public Route() {
        this.WatcherId = null;
        this.RouteId = null;
        this.UnitID = null;
        this.ScheduledDate = null;
        this.ActivatedOn = null;
        this.LastStopID = null;
        this.ClosedOn = null;
        this.CreatedOn = null;
        this.StatusRoute = null;
    }

    public String getWatcherId() {
        return WatcherId;
    }

    public void setWatcherId(String WatcherId) {
        this.WatcherId = WatcherId;
    }

    public String getRouteId() {
        return RouteId;
    }

    public void setRouteId(String RouteId) {
        this.RouteId = RouteId;
    }

    public String getUnitID() {
        return UnitID;
    }

    public void setUnitID(String UnitID) {
        this.UnitID = UnitID;
    }

    public String getScheduledDate() {
        return ScheduledDate;
    }

    public void setScheduledDate(String ScheduledDate) {
        this.ScheduledDate = ScheduledDate;
    }

    public String getActivatedOn() {
        return ActivatedOn;
    }

    public void setActivatedOn(String ActivatedOn) {
        this.ActivatedOn = ActivatedOn;
    }

    public String getLastStopID() {
        return LastStopID;
    }

    public void setLastStopID(String LastStopID) {
        this.LastStopID = LastStopID;
    }

    public String getClosedOn() {
        return ClosedOn;
    }

    public void setClosedOn(String ClosedOn) {
        this.ClosedOn = ClosedOn;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String CreatedOn) {
        this.CreatedOn = CreatedOn;
    }

    public String getStatusRoute() {
        return StatusRoute;
    }

    public void setStatusRoute(String StatusRoute) {
        this.StatusRoute = StatusRoute;
    }
    
    @Override
    public String toString() {
        return "Routes:: WatcherId="+this.WatcherId+" RouteID=" + this.RouteId 
                + " ScheduledDate="+this.ScheduledDate+" ActivatedOn=" + this.ActivatedOn 
                + " LastStopID="+ this.LastStopID + " ClosedOn=" + this.ClosedOn
                + " CreatedOn=" + this.CreatedOn + " StatusRoute=" + this.StatusRoute;
    }
}