package peopleMoverWS.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverWS.model.Unit;
import peopleMoverWS.model.ValidateUser;
import peopleMoverWS.util.MyCx;
import peopleMoverWS.util.PropertyReader;

@RestController
public class UnitListController {
	
	 @RequestMapping("/getunitlist")
	    public List<?> getunitlist() {
	        
		 
		 
		 return ListUnitCx();
	    }
	 private List<Unit> ListUnitCx()
	 {
		  String filename = "ppmWS.properties";
		  String login="";
		  String password="";
	      String domain = "";
	      String userValidationRequest="";
	      String unitListRequest="";
	      String tokenValidationRequest="";
	      String tokenString="";
		  PropertyReader propReader = new PropertyReader(filename);
		  try {
			 login=propReader.getProperty("login");
			 password = propReader.getProperty("password");
			 domain = propReader.getProperty("domain");
			 userValidationRequest = propReader.getProperty("userValidationRequest");
			 unitListRequest = propReader.getProperty("unitListRequest");	
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
		  System.out.println(tokenStatus);
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
	         
	         String urlParamUnitList = "token="+tokenString;
	         unitListRequest = domain+unitListRequest;
	        
	         MyCx mcUnitL = new MyCx();
	         UnitListHandler gUnitListHlnd = new UnitListHandler();
	        
	         mcUnitL.GetCx(urlParamUnitList, unitListRequest, gUnitListHlnd);
	         //System.out.println(vu.getToken());
	         List<Unit> uList = gUnitListHlnd.getUnitList();
	           return uList;
	 }
	 
	 

}
