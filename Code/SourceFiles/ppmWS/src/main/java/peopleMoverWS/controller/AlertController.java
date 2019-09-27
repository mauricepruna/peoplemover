package peopleMoverWS.controller;


import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverDB.dao.AlertDAO;
import peopleMoverDB.dao.UserDAO;
import peopleMoverDB.model.Alert;
import peopleMoverDB.model.User;
import peopleMoverWS.model.FormattedMessage;



@RestController
public class AlertController {
	@RequestMapping("/alert")
	public FormattedMessage alertHandler(@RequestParam(value="token", required=false)final String token,
			@RequestParam(value="message", required=false) final String message) 
	{

		FormattedMessage alert  = alertHandlerCx(token,message);
		
		
		return alert ;
	}
	private FormattedMessage alertHandlerCx(String token, String message)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AlertDAO alertDAO = ctx.getBean("AlertDAOJDBCTemplate",AlertDAO.class);
		UserDAO loginUserDAO = ctx.getBean("UserDAOJDBCTemplate", UserDAO.class);
		FormattedMessage formatted = new FormattedMessage();
		String admin  = "1";
		Alert alert = new Alert();
		formatted.setCode("0");
		formatted.setMessage("Not Defined Alert");
		User user = new User();
		if(token!=null && !token.equalsIgnoreCase(""))
		{
			try{
			user  = loginUserDAO.getByToken(token);
			}
			catch(EmptyResultDataAccessException e)
			{
				e.printStackTrace();
				
			}
			finally
			{
				formatted.setCode("0");
				formatted.setMessage("Not Defined Alert");
				
			}
			
			
			
		
			if(token!=null && !token.equalsIgnoreCase("")&& admin.equalsIgnoreCase(user.getIsadmin()))
			{
				if(message!=null && !message.equalsIgnoreCase(""))
				{
					alert.setToken(token);
					alert.setMessage(message);
					
				}
				else
				{
					alert.setToken(token);
					alert.setMessage("Not Defined Alert");
				}
				
				int result=0;
				
				result = alertDAO.save(alert);
				if(result>0)
				{
					formatted.setCode("1");
					formatted.setMessage("Inserted Alert");
				}
						
			}
			else
			{
				List<Alert> listalert = alertDAO.getAll();
				if(!listalert.isEmpty())
				{
				alert = listalert.get(0);
				formatted.setCode("1");
				formatted.setMessage(alert.getMessage());
				}
				
			}
			
			
		}
		else
		{
			List<Alert> listalert = alertDAO.getAll();
			if(!listalert.isEmpty())
			{
			alert = listalert.get(0);
			formatted.setCode("1");
			formatted.setMessage(alert.getMessage());
			}
		}
		
		return formatted;
		
	}
	

}
