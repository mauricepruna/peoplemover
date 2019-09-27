package peopleMoverWS.controller;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import peopleMoverWS.model.Unit;

/**
 *
 * @author maurice
 */
public class UnitListHandler extends DefaultHandler {
	 private List<Unit> unitList;
	 private Unit u;
	 private boolean bID;
	 private boolean bUnitID;
	 private boolean bLastLatitude;
	 private boolean bLastLongitude;
	 private boolean bAddress;
	 private boolean bLastEventDate;
	 private boolean bSpeed;
	 private boolean bDirection;
	  public UnitListHandler()
	  {
	    unitList = null;
	    u = null;        
	    bID = false;
	    bUnitID = false;
	    bLastLatitude = false;
	    bLastLongitude = false;
	    bAddress = false;
	    bLastEventDate = false;
	    bSpeed = false;
	    bDirection = false;
	  }
	    
	    
	     public List<Unit> getUnitList() {
	        return unitList;
	    }

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
	        if (qName.equalsIgnoreCase("Table")) {
	            u = new Unit();
	            if(unitList==null)
	            {
	                unitList = new ArrayList<Unit>();
	            }
	        }
	        else if(qName.equalsIgnoreCase("ID"))
	        {
	            bID = true;
	           
	        }
	        else if(qName.equalsIgnoreCase("UnitID"))
	        {
	            bUnitID = true;
	        }
	        else if (qName.equalsIgnoreCase("LastLatitude"))
	        {
	            bLastLatitude = true;
	        }
	        else if (qName.equalsIgnoreCase("LastLongitude"))
	        {
	            bLastLongitude = true;
	        }
	        else if(qName.equalsIgnoreCase("Address"))
	        {
	            bAddress = true;
	        }
	        else if(qName.equalsIgnoreCase("LastEventDate"))
	        {
	        	bLastEventDate = true;
	        }
	        else if(qName.equalsIgnoreCase("Speed"))
	        {
	        	bSpeed = true;
	        }
	        else if(qName.equalsIgnoreCase("Direction"))
	        {
	        	bDirection = true;
	        }
	            
	        
	    }
	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	        if(bID)
	        {
	            bID = false;
	        }
	        else if(bUnitID)
	        {
	            bUnitID = false;
	        }
	        else if(bLastLatitude)
	        {
	            bLastLatitude = false;
	        }
	           else if(bLastLongitude)
	        {
	            bLastLongitude = false;
	        }
	            else if(bAddress)
	        {
	            bAddress = false;
	        }
	        else if(qName.equalsIgnoreCase("LastEventDate"))
	        {
	        	bLastEventDate = false;
	        }
	        else if(qName.equalsIgnoreCase("Speed"))
	        {
	        	bSpeed = false;
	        }
	        else if(qName.equalsIgnoreCase("Direction"))
	        {
	        	bDirection = false;
	        }
	        else if (qName.equalsIgnoreCase("Table")) {
	        	unitList.add(u);
	        }
	    } 
	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	        if(bID)
	        {
	            u.setID(new String(ch, start, length));
	        }
	        else if(bUnitID)
	        {
	            u.setUnitID(new String(ch, start, length));
	        }
	        else if(bLastLatitude)
	        {
	            u.setLastLatitude(new String(ch, start, length));
	        }
	           else if(bLastLongitude)
	        {
	            u.setLastLongitude(new String(ch, start, length));
	        }
	        else if(bAddress)
	        {
	            u.setAddress(new String(ch, start, length));
	        }
	        else if(bLastEventDate)
	        {
	            u.setLastEventDate(new String(ch, start, length));
	        }
	        else if(bSpeed)
	        {
	            u.setSpeed(new String(ch, start, length));
	        }
	        else if(bDirection)
	        {
	            u.setDirection(new String(ch, start, length));
	        }
	    }
	    
	    
	}
