package peopleMoverWS.controller;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import peopleMoverWS.model.Location;
//import peopleMoverWS.model.Unit;

/**
 *
 * @author maurice
 */
public class LocationHandler extends DefaultHandler{
    private Location loc;
    private boolean bAddress;
    private boolean bCity;
    private boolean bState;
    private boolean bPostalCode;
    private boolean bCountryCode;
    private boolean bLatitude;
    private boolean bLongitude;
    private boolean bLastEventDate;
    private boolean bHeading;
    private String UnitID;
    public LocationHandler(String UnitID) {
    	this.UnitID = UnitID;
        loc = null;
        bAddress = false;
        bCity = false;
        bState = false;
        bPostalCode = false;
        bCountryCode = false;
        bLatitude = false;
        bLongitude = false;
        bLastEventDate = false;
        bHeading = false;
        
               
    }
    
     public Location getLocation(){
        return loc;
    }  
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
        if (qName.equalsIgnoreCase("Position")) {
            loc = new Location(this.UnitID);
            
        }
        else if(qName.equalsIgnoreCase("Address"))
        {
            bAddress = true;
           
        }
        else if(qName.equalsIgnoreCase("City"))
        {
            bCity = true;
        }
        else if (qName.equalsIgnoreCase("State"))
        {
            bState = true;
        }
        else if (qName.equalsIgnoreCase("PostalCode"))
        {
            bPostalCode = true;
        }
        else if(qName.equalsIgnoreCase("CountryCode"))
        {
            bCountryCode = true;
        }
        else if(qName.equalsIgnoreCase("Latitude"))
        {
            bLatitude = true;
        }
        else if(qName.equalsIgnoreCase("Longitude"))
        {
            bLongitude = true;
        }
        else if(qName.equalsIgnoreCase("LastEventDate"))
        {
            bLastEventDate = true;
        }
        else if(qName.equalsIgnoreCase("Heading"))
        {
            bHeading = true;
        }
            
        
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("Address"))
        {
            bAddress = false;
           
        }
        else if(qName.equalsIgnoreCase("City"))
        {
            bCity = false;
        }
        else if (qName.equalsIgnoreCase("State"))
        {
            bState = false;
        }
        else if (qName.equalsIgnoreCase("PostalCode"))
        {
            bPostalCode = false;
        }
        else if(qName.equalsIgnoreCase("CountryCode"))
        {
            bCountryCode = false;
        }
        else if(qName.equalsIgnoreCase("Latitude"))
        {
            bLatitude = false;
        }
        else if(qName.equalsIgnoreCase("Longitude"))
        {
            bLongitude = false;
        }
        else if(qName.equalsIgnoreCase("LastEventDate"))
        {
            bLastEventDate = false;
        }
        else if(qName.equalsIgnoreCase("Heading"))
        {
            bHeading = false;
        }
//           else if (qName.equalsIgnoreCase("Position")) {
//            loc = new Location();
//            
//        }
    } 
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(bAddress)
        {
            loc.setAddress(new String(ch, start, length));
        }
        else if(bCity)
        {
            loc.setCity(new String(ch, start, length));
        }
        else if(bState)
        {
            loc.setState(new String(ch, start, length));
        }
           else if(bPostalCode)
        {
            loc.setPostalCode(new String(ch, start, length));
        }
        else if(bCountryCode)
        {
            loc.setCountryCode(new String(ch, start, length));
        }
        else if(bLatitude)
        {
            loc.setLatitude(new String(ch, start, length));
        }
        else if(bLongitude)
        {
            loc.setLongitude(new String(ch, start, length));
        }
        else if(bLastEventDate)
        {
            loc.setLastEventDate(new String(ch, start, length));
        }
        else if(bHeading)
        {
            loc.setHeading(new String(ch, start, length));
        }
    }
}