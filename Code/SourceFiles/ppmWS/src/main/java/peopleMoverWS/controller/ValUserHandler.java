package peopleMoverWS.controller;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import peopleMoverWS.model.ValidateUser;
public class ValUserHandler extends DefaultHandler {
    
	 private ValidateUser vUser = null;
	    public ValUserHandler(ValidateUser vUser)
	    {
	        this.vUser = vUser;
	    }
	  
	    public ValidateUser getValUserToken()
	    {
	        return vUser;
	    }
	    boolean bTokenS = false;
	    boolean bTokenF = false;
	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes)
	            throws SAXException 
	    {
	        
	        if(qName.equalsIgnoreCase("string"))
	        {
	            //String domain = attributes.getValue("xmlns");
	            bTokenS = true;
	        }
	        
	    }
//	     @Override
//	    public void endElement(String uri, String localName, String qName) throws SAXException {
//	        if (qName.equalsIgnoreCase("string")) {
//	           bTokenF = true;
//	        }
//	    }
	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	 
	        if (bTokenS) {
	            
	            vUser.setToken(new String(ch, start, length));
	        }
	    }
	 
	    
	    
	}