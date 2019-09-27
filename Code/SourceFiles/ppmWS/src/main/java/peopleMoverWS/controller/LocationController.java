package peopleMoverWS.controller;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverWS.model.Location;
import peopleMoverWS.model.ValidateUser;
import peopleMoverWS.util.MyCx;
import peopleMoverWS.util.PropertyReader;

@RestController
public class LocationController {
	@RequestMapping("/getlocation")
	public Location getLocation(/*@RequestParam(value="filterBy", required=true) String filterBy,*/@RequestParam(value="id", required=true) String id) 
	{
		Location loc = getLocationCx(/*filterBy,*/ id);
		return loc ;
	}
	private Location getLocationCx(/*String filter,*/String filterId)
	{
		 String filename = "ppmWS.properties";
		  String login="";
		  String password="";
	      String domain = "";
	      String userValidationRequest="";
	      String locationRequest="";
	      String tokenValidationRequest="";
	      String tokenString="";
		  PropertyReader propReader = new PropertyReader(filename);
		  try {
			 login=propReader.getProperty("login");
			 password = propReader.getProperty("password");
			 domain = propReader.getProperty("domain");
			 userValidationRequest = propReader.getProperty("userValidationRequest");
			 locationRequest = propReader.getProperty("locationRequest");
			 tokenValidationRequest = propReader.getProperty("tokenValidationRequest");
			 tokenString = propReader.getProperty("tokenString");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String urlParamToken = "token="+tokenString;
		  tokenValidationRequest=domain+tokenValidationRequest;
		  MyCx mcValToken = new MyCx();
	        ValTokenHandler valTokenHlnd = new ValTokenHandler();
	        mcValToken.GetCx(urlParamToken, tokenValidationRequest, valTokenHlnd);
	        
	        String tokenStatus = valTokenHlnd.getTokenStatus();
		  
		  if(tokenStatus.equalsIgnoreCase("false"))
		  {	  
	        ValidateUser vu = new ValidateUser(login,password);
	        String urlParameters = "login="+vu.getLogin()+"&password="+vu.getPass()+"&AppId="+vu.getAppId()+"&IPAddress=";
	 
	        userValidationRequest= domain+userValidationRequest;        
	       
	       

	         ValUserHandler valUserHlnd = new ValUserHandler(vu);
	         MyCx mc = new MyCx();
	         mc.GetCx(urlParameters, userValidationRequest, valUserHlnd);	         
	         tokenString  = vu.getToken();
		  }
	         	         
	         String urlParamLocation = "token="+tokenString+"&filterBy=UNITID"/*+filter*/+"&id="+filterId;
	         locationRequest = domain+locationRequest;
	        
	         MyCx mcLocation = new MyCx();
	         LocationHandler locHnld = new LocationHandler(filterId);	        
	         mcLocation.GetCx(urlParamLocation, locationRequest, locHnld);
	         //System.out.println(vu.getToken());
	         
	           return locHnld.getLocation();
	         
	}

}
