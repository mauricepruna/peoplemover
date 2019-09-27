package peopleMoverWS.controller;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import peopleMoverWS.model.Route;

/**
 *
 * @author maurice
 */
public class RoutesHandler  extends DefaultHandler{
    private List<Route> routeList;
    private Route r;
    private boolean bWatcherId;
    private boolean bRouteId;
    private boolean bUnitID;
    private boolean bScheduledDate;
    private boolean bActivatedOn;
    private boolean bLastStopID;
    private boolean bClosedOn;
    private boolean bCreatedOn;
    private boolean bStatusRoute;

    public RoutesHandler() {
        this.routeList = null;
        this.r = null;
        this.bWatcherId = false;
        this.bRouteId = false;
        this.bUnitID = false;
        this.bScheduledDate = false;
        this.bActivatedOn = false;
        this.bLastStopID = false;
        this.bClosedOn = false;
        this.bCreatedOn = false;
        this.bStatusRoute = false;
    }
      public List<Route> getUnitList(){
        return routeList;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
        if (qName.equalsIgnoreCase("Table")) {
            r = new Route();
            if(routeList==null)
            {
                routeList = new ArrayList<Route>();
            }
        }
        else if(qName.equalsIgnoreCase("WatcherId"))
        {
            bWatcherId = true;
           
        }
        else if(qName.equalsIgnoreCase("UnitID"))
        {
            bUnitID = true;
        }
        else if (qName.equalsIgnoreCase("StatusRoute"))
        {
            bStatusRoute = true;
        }
        
            
        
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(bWatcherId)
        {
            bWatcherId = false;
        }
        else if(bUnitID)
        {
            bUnitID = false;
        }
        else if(bStatusRoute)
        {
            bStatusRoute = false;
        }
        else if (qName.equalsIgnoreCase("Table")) {
           routeList.add(r);
        }
    } 
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(bWatcherId)
        {
            r.setWatcherId(new String(ch, start, length));
        }
        else if(bUnitID)
        {
            r.setUnitID(new String(ch, start, length));
        }
        else if(bStatusRoute)
        {
            r.setStatusRoute(new String(ch, start, length));
        }
          
    }
    
    
}