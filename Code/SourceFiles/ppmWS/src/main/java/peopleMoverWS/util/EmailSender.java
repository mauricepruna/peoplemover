package peopleMoverWS.util;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.activation.*;
import javax.xml.bind.DatatypeConverter;

public class EmailSender {
	String host;
	String port;
	final String mailusername;
	final String mailpassword;
	Properties prop;
	Session session;
	public EmailSender(String host, String port, String username, String password )
	{
		this.host = host;
		this.port = port;
		mailusername=username;
		mailpassword=password;
		prop = new Properties();
		prop.put("mail.smtp.host", this.host);
		prop.put("mail.smtp.socketFactory.port", this.port);
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", this.port);
		
		session = Session.getDefaultInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(mailusername,mailpassword);
					}
				});
	}

	public boolean  Send(String fromAddress,String toAddress, String subjectAddress, String messageAddress, String attachment) throws IOException
	{
		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromAddress));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toAddress));
			message.setSubject(subjectAddress);
			
			//message.setText(messageAddress);
			// Send message
			
		       
			
			
			if(attachment!=null && !"".equals(attachment))
			{
				 MimeBodyPart messageBodyPart = new MimeBodyPart();
				 messageBodyPart.setContent("<h1>"+subjectAddress+": "+fromAddress+"</h1>"+"<p>"+messageAddress+"</p>",
		                    "text/html");
				 Multipart multipart = new MimeMultipart();
			        multipart.addBodyPart(messageBodyPart);
			        messageBodyPart = new MimeBodyPart();
		        
				 String[] imageArray = attachment.split(",");
				 String front = imageArray[0];
				 String back = imageArray[1];
				 
				byte[] fileattach = DatatypeConverter.parseBase64Binary(back);
						//Base64.decodeBase64(back);
				 Pattern pattern = Pattern.compile(":(.*?);");
 		        Matcher matcher = pattern.matcher(front);
 		        String type="";
 		        if (matcher.find()) {
 		        	type=matcher.group(1);
				DataSource source = new ByteArrayDataSource(fileattach, type );
				messageBodyPart.setDataHandler(new DataHandler(source));
 		        }
    		        String[] extension = type.split("/");
    		        messageBodyPart.setFileName(fromAddress+"."+extension[1]);
    		        
				
				
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
				

		        		
		       
			}
			else
			{
				message.setContent("<h1>"+subjectAddress+": "+fromAddress+"</h1>"+"<p>"+messageAddress+"</p>",
	                    "text/html");
			}
			
			

		        
		        Transport.send(message);
			return true;
			
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
