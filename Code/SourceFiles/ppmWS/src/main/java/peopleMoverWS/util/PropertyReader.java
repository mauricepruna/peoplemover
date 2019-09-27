package peopleMoverWS.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyReader {
	String filename;
	public PropertyReader(String filename)
	{
		this.filename = filename;
	}
	
	public String getProperty(String property) 
	{
		String result="";
		Properties prop = new Properties();
		 try{
		  InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
		 
	        prop.load(inputStream);
	       
		  }catch(NullPointerException| IOException e ){System.err.println("property file '" + filename + "' not found in the classpath");}
		  result  = prop.getProperty(property);
		  if(result==""||result==null)
		  {
			  try {
				throw new Exception("Property not found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }			  
			  
			return result;
		
	}
	

}
