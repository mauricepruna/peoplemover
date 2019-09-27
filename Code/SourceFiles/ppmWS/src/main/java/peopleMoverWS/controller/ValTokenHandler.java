package peopleMoverWS.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ValTokenHandler extends DefaultHandler{
	boolean bStatus=false;
	String tokenStatus="";
	public void setTokenStatus(String tokenStatus)
	{
		this.tokenStatus = tokenStatus;
	}
	public String getTokenStatus()
	{
		return tokenStatus;
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException 
    {
        
        if(qName.equalsIgnoreCase("boolean"))
        {
            //String domain = attributes.getValue("xmlns");
            bStatus = true;
        }
        
    }
	@Override
    public void characters(char ch[], int start, int length) throws SAXException {
 
        if (bStatus) {
            
            tokenStatus=new String(ch, start, length);
        }
    }

}
