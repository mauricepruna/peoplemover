package peopleMoverWS.model;

/**
*
* @author maurice
*/
public class Unit {
  
private String ID;   
private String UnitID;
private String LicencePlate;
private String ShortName;
private String Description;
private String SerialNumber;
private String IMEI;
private String Address;
private String City;
private String State;
private String CountryCode;
private String PostalCode;
private String LastEventCode;
private String EventName;
private String LastEventDate;
private String LastLatitude;
private String LastLongitude;
private String Speed;
private String Direction;
private String DealerID;
private String CompanyID;
private String ContactName;
private String IconPath;
private String AssignedDriver;
private String DriverID;
private String LocalLastEventDatetxt;

   public String getID() {
       return ID;
   }

   public void setID(String ID) {
       this.ID = ID;
   }

  
   public String getUnitID() {
       return UnitID;
   }

   public void setUnitID(String UnitID) {
       this.UnitID = UnitID;
   }

   public String getLicencePlate() {
       return LicencePlate;
   }

   public void setLicencePlate(String LicencePlate) {
       this.LicencePlate = LicencePlate;
   }

   public String getShortName() {
       return ShortName;
   }

   public void setShortName(String ShortName) {
       this.ShortName = ShortName;
   }

   public String getDescription() {
       return Description;
   }

   public void setDescription(String Description) {
       this.Description = Description;
   }

   public String getSerialNumber() {
       return SerialNumber;
   }

   public void setSerialNumber(String SerialNumber) {
       this.SerialNumber = SerialNumber;
   }

   public String getIMEI() {
       return IMEI;
   }

   public void setIMEI(String IMEI) {
       this.IMEI = IMEI;
   }

   public String getAddress() {
       return Address;
   }

   public void setAddress(String Address) {
       this.Address = Address;
   }

   public String getCity() {
       return City;
   }

   public void setCity(String City) {
       this.City = City;
   }

   public String getState() {
       return State;
   }

   public void setState(String State) {
       this.State = State;
   }

   public String getCountryCode() {
       return CountryCode;
   }

   public void setCountryCode(String CountryCode) {
       this.CountryCode = CountryCode;
   }

   public String getPostalCode() {
       return PostalCode;
   }

   public void setPostalCode(String PostalCode) {
       this.PostalCode = PostalCode;
   }

   public String getLastEventCode() {
       return LastEventCode;
   }

   public void setLastEventCode(String LastEventCode) {
       this.LastEventCode = LastEventCode;
   }

   public String getEventName() {
       return EventName;
   }

   public void setEventName(String EventName) {
       this.EventName = EventName;
   }

   public String getLastEventDate() {
       return LastEventDate;
   }

   public void setLastEventDate(String LastEventDate) {
       this.LastEventDate = LastEventDate;
   }

   public String getLastLatitude() {
       return LastLatitude;
   }

   public void setLastLatitude(String LastLatitude) {
       this.LastLatitude = LastLatitude;
   }

   public String getLastLongitude() {
       return LastLongitude;
   }

   public void setLastLongitude(String LastLongitude) {
       this.LastLongitude = LastLongitude;
   }

   public String getSpeed() {
       return Speed;
   }

   public void setSpeed(String Speed) {
       this.Speed = Speed;
   }

   public String getDirection() {
       return Direction;
   }

   public void setDirection(String Direction) {
       this.Direction = Direction;
   }

   public String getDealerID() {
       return DealerID;
   }

   public void setDealerID(String DealerID) {
       this.DealerID = DealerID;
   }

   public String getCompanyID() {
       return CompanyID;
   }

   public void setCompanyID(String CompanyID) {
       this.CompanyID = CompanyID;
   }

   public String getContactName() {
       return ContactName;
   }

   public void setContactName(String ContactName) {
       this.ContactName = ContactName;
   }

   public String getIconPath() {
       return IconPath;
   }

   public void setIconPath(String IconPath) {
       this.IconPath = IconPath;
   }

   public String getAssignedDriver() {
       return AssignedDriver;
   }

   public void setAssignedDriver(String AssignedDriver) {
       this.AssignedDriver = AssignedDriver;
   }

   public String getDriverID() {
       return DriverID;
   }

   public void setDriverID(String DriverID) {
       this.DriverID = DriverID;
   }

   public String getLocalLastEventDatetxt() {
       return LocalLastEventDatetxt;
   }

   public void setLocalLastEventDatetxt(String LocalLastEventDatetxt) {
       this.LocalLastEventDatetxt = LocalLastEventDatetxt;
   }
   @Override
   public String toString() {
       return "Unit:: ID="+this.ID+" UnitID=" + this.UnitID + " Address="+this.Address+" LastLatitude=" + this.LastLatitude + " LastLongitude=" + this.LastLongitude;
   }
}
