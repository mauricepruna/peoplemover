package peopleMoverWS.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author maurice
 */
public class MyCx {
    private String temp;
    public String HttpCx(String urlParameters, String request)
    {
                try{
        URL url = new URL(request); 
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();           
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setInstanceFollowRedirects(false); 
        connection.setRequestMethod("POST"); 
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
        connection.setUseCaches (false);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        InputStream inputStream = null;
                if (connection != null) {
                    inputStream = connection.getInputStream();
                } else
					throw new IOException("Connection is not established.");

                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        inputStream));
                //List<String> response = new ArrayList<String>();

                String line = "";
                String buff ="";
                while ((buff = reader.readLine()) != null) {
                    //response.add(line);
                    line+=buff;
                }
                //temp = (String[]) response.toArray(new String[0]);

                temp = line;//response.toString();
                reader.close();
        connection.disconnect();
                }
                catch(IOException e){ e.printStackTrace();}

                return temp;
    }
    public void GetCx(String urlParameters,String request, DefaultHandler dh)
    {
        try{
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        temp = HttpCx(urlParameters, request);
        InputSource is = new InputSource(new StringReader(temp));
        saxParser.parse(is, dh);
        }catch(IOException|ParserConfigurationException | SAXException e){e.printStackTrace();}
    }
    
    
    
}
