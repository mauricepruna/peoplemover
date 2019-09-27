package peopleMoverWS.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverDB.dao.FavoriteDAO;
import peopleMoverDB.model.Favorite;
import peopleMoverWS.model.FormattedMessage;


@RestController
public class FavoriteController {
	@RequestMapping("/setalarm")
	public FormattedMessage setAlarm(@RequestParam(value="token", required=true)String token,@RequestParam(value="stopid", required=true) String stopid,
			@RequestParam(value="routeid", required=true) String routeid,@RequestParam(value="remove", required=true) String remove,
			@RequestParam(value="emailflag", required=false)final String emailflag,
			@RequestParam(value="time", required=false)final String time) 
	{
		FormattedMessage fm;
		fm = setAlarmCx(token, stopid, routeid,remove, emailflag, time);
		return fm;
	}
	private FormattedMessage setAlarmCx(String token,String StopId,String RouteId,String remove, String emailflag, String time)
	{
		FormattedMessage fMessage = new FormattedMessage();
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//To use JdbcTemplate
		FavoriteDAO favDAO = ctx.getBean("FavoriteDAOJDBCTemplate", FavoriteDAO.class);
		Favorite fav = new Favorite();
		boolean flag=false;
		
		if(!remove.equalsIgnoreCase("true"))
		{
			fav.setUserToken(token);
			fav.setStopId(StopId);
			fav.setRouteId(RouteId);
			fav.setTime(time);
			if(emailflag!=null && !emailflag.equalsIgnoreCase(""))
			{
					if(emailflag.equalsIgnoreCase("true"))
					{
						fav.setEmailFlag("1");		
						flag=true;
					}
					else
					{
						fav.setEmailFlag("0");
						flag=false;
					}
					
					int out  = favDAO.update(fav);
					ctx.close();
					if(out!=0)
					{
						if(flag)
						{
							fMessage.setCode("1");
							fMessage.setMessage("Alarm Enabled");
						}
						else
						{
							fMessage.setCode("1");
							fMessage.setMessage("Alarm Disabled");
						}
					}
					else
					{
						fMessage.setCode("0");
						fMessage.setMessage("Alarm Error");
					}
			}
			else
			{
				fav.setUserToken(token);
				fav.setStopId(StopId);
				fav.setRouteId(RouteId);
				int out = favDAO.save(fav);
				ctx.close();
				if(out!=0)
				{
					fMessage.setCode("1");
					fMessage.setMessage("Favorite Inserted");
				}
				else
				{
					fMessage.setCode("0");
					fMessage.setMessage("Insertion Error");
				}
			}
			
		}
		else
		{
			int out = favDAO.deleteFavorite(token, StopId, RouteId);
			ctx.close();
			if(out!=0)
			{
				fMessage.setCode("1");
				fMessage.setMessage("Favorite Deleted");
			}
			else
			{
				fMessage.setCode("0");
				fMessage.setMessage("Deletion Error");
			}
		}
		
		
		return fMessage;
	}

}
