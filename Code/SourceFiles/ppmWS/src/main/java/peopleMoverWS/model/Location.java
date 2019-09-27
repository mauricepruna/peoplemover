package peopleMoverWS.model;
/**
*
* @author maurice
*/
public class Location {
   String UnitID;
   String Address;
   String City;
   String State;
   String PostalCode;
   String CountryCode;
   String Latitude;
   String Longitude;
   String LastEventDate;
   String Heading;
   String InsertionTime;

   public Location() {
	   this.UnitID = null;
       this.Address = null;
       this.City = null;
       this.State = null;
       this.PostalCode =null;
       this.CountryCode = null;
       this.Latitude = null;
       this.Longitude = null;
       this.LastEventDate = null;
       this.Heading = null;  
       this.InsertionTime=null;
       
   }
   public Location(String UnitID) {
	   this.UnitID = UnitID;
       this.Address = null;
       this.City = null;
       this.State = null;
       this.PostalCode =null;
       this.CountryCode = null;
       this.Latitude = null;
       this.Longitude = null;
       this.LastEventDate = null;
       this.Heading = null;
      
       
   }

   public String getUnitID() {
	return UnitID;
}

public void setUnitID(String unitID) {
	UnitID = unitID;
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

   public String getPostalCode() {
       return PostalCode;
   }

   public void setPostalCode(String PostalCode) {
       this.PostalCode = PostalCode;
   }

   public String getCountryCode() {
       return CountryCode;
   }

   public void setCountryCode(String CountryCode) {
       this.CountryCode = CountryCode;
   }

   public String getLatitude() {
       return Latitude;
   }

   public void setLatitude(String Latitude) {
       this.Latitude = Latitude;
   }

   public String getLongitude() {
       return Longitude;
   }

   public void setLongitude(String Longitude) {
       this.Longitude = Longitude;
   }

   public String getLastEventDate() {
       return LastEventDate;
   }

   public void setLastEventDate(String LastEventDate) {
       this.LastEventDate = LastEventDate;
   }

   public String getHeading() {
       return Heading;
   }

   public void setHeading(String Heading) {
       this.Heading = Heading;
   }
   
   @Override
   public String toString() {
       return "Location:: Address="+this.Address+" City=" + this.City + " State="
               +this.State+" PostalCode=" + this.PostalCode + " CountryCode=" 
               + this.CountryCode + " Latitude=" + this.Latitude 
               + " Longitude=" + this.Longitude + " LastEventDate=" + this.LastEventDate
               + " Heading=" + this.Heading;
   }
       
   
}
