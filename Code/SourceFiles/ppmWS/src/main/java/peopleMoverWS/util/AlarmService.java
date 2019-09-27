package peopleMoverWS.util;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import peopleMoverDB.dao.FavoriteDAO;
import peopleMoverDB.dao.RouteDAO;
import peopleMoverDB.dao.StopsDAO;
import peopleMoverDB.dao.UserDAO;
import peopleMoverDB.model.Favorite;
import peopleMoverDB.model.Route;
import peopleMoverDB.model.Stops;
import peopleMoverDB.model.User;
import peopleMoverWS.controller.EmailSenderController;
import peopleMoverWS.getEstimatedTime.EstimatedTime;



@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class AlarmService extends Service{
	@Scheduled(cron="${cronsendalarm}")
	//@Scheduled(cron="0/11 * * * * MON-FRI")
	public void ServiceMethod()
	{
		System.out.println("Alarm Method executed at every 1 min");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//To use JdbcTemplate
		FavoriteDAO favDAO = ctx.getBean("FavoriteDAOJDBCTemplate", FavoriteDAO.class);
		UserDAO userDAO = ctx.getBean("UserDAOJDBCTemplate", UserDAO.class);
		StopsDAO stopsDAO = ctx.getBean("StopsDAOJDBCTemplate", StopsDAO.class);
		RouteDAO routeDAO = ctx.getBean("RouteDAOJDBCTemplate", RouteDAO.class);
		List<Favorite> favlist = favDAO.getAll();
		if(!favlist.isEmpty())
		{
		
			//EmailSenderController emailController = new EmailSenderController();
			String filename = "ppmWS.properties";
			  String emailhost="";
			  String emailport="";
		      String emailusername = "";
		      String emailpassword="";
		      String emailFROM ="";
			  PropertyReader propReader = new PropertyReader(filename);
			  try {
				  emailhost=propReader.getProperty("emailhost");
				  emailport = propReader.getProperty("emailport");
				  emailusername = propReader.getProperty("emailusername");
				  emailpassword = propReader.getProperty("emailpassword");	 
				  emailFROM = propReader.getProperty("emailreceiver");
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EmailSender emailsender = new EmailSender(emailhost,emailport,emailusername, emailpassword);
			
			EstimatedTime est = new EstimatedTime();
			String estTime = "00:"+getRandomNumber(20)+":00";
			for(Favorite fav : favlist)
			{
				String emailflag = fav.getEmailFlag();
				if(emailflag!=null && !emailflag.equalsIgnoreCase("") && emailflag.equalsIgnoreCase("true"))
				{
					String token = fav.getUserToken();
					String StopId = fav.getStopId();
					String RouteId = fav.getRouteId();
					String time = fav.getTime();
					
					//est.getStops(RouteId, StopId).getMessage();
					
					if(!estTime.equalsIgnoreCase("N/A"))
					{
						Pattern pattern = Pattern.compile(":(.*?):");
		 		        Matcher matcher = pattern.matcher(estTime);
		 		       String minutes="";
		 		        if (matcher.find()) {
		 		        	minutes=matcher.group(1);
		 		        }
		 		        System.out.println(minutes);
		 		       //minutes.equalsIgnoreCase(time);
		 		        if(minutes.equalsIgnoreCase(time))
		 		        {
		 		        	User user = userDAO.getByToken(token);
		 		        	Stops stop = stopsDAO.getByStopsAndRoute(StopId, RouteId);
		 		        	Route route = routeDAO.getByRouteID(RouteId);
		 		        	String toAddress = user.getEmail();
		 		        	String message = route.getName()+" Trolley Arriving at Stop: "+stop.getStreet();
		 		        	
		 		        	try {
								emailsender.Send(emailFROM, toAddress, "ALARM" ,message , null);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		 		        }
					}
					
				}
			}
		}
		
		
		
	}
	private static int getRandomNumber(int max)
	{
		Random ran = new Random();
		return 1 + ran.nextInt(max);
	}

}