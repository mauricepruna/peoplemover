package peopleMoverWS.util;


import java.util.UUID;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
public class EmailManager {
	
	public static boolean emailCheck(String email)
	{
		if(email==null) return false;
		boolean isValid = true;
		try {
			//
			// Create InternetAddress object and validated the supplied
			// address which is this case is an email address.
			if(validNameAndDomain(email))
			{			
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			
			}
			else {isValid=false;}
		} catch (AddressException e) {
			System.out.println(" AddressException Occurred for: " + email);
		}
		return isValid;
	}
	private static boolean validNameAndDomain(String email){
	    String[] tokens = email.split("@");
	    return 
	      tokens.length == 2 && 
	      !tokens[0].equalsIgnoreCase("") &&
	      !tokens[1].equalsIgnoreCase("") 
	    ;
	  }
	public static String generateToken()
	{
		return UUID.randomUUID().toString();
	}

}
