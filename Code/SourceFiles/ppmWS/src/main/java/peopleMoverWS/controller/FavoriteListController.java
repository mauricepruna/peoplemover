package peopleMoverWS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverDB.dao.FavoriteDAO;
import peopleMoverDB.dao.RouteDAO;
import peopleMoverDB.dao.StopsDAO;
import peopleMoverDB.model.Favorite;
import peopleMoverDB.model.FavoritesList;
import peopleMoverDB.model.Route;
import peopleMoverDB.model.Stops;
import peopleMoverWS.getEstimatedTime.EstimatedTime;

@RestController
public class FavoriteListController {
	@RequestMapping("/getfavoritelist")
	public List<?> getList(@RequestParam(value="token", required=true) String token)
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//To use JdbcTemplate
		FavoriteDAO favDAO = ctx.getBean("FavoriteDAOJDBCTemplate", FavoriteDAO.class);
		StopsDAO stopDAO = ctx.getBean("StopsDAOJDBCTemplate", StopsDAO.class);
		RouteDAO routeDAO = ctx.getBean("RouteDAOJDBCTemplate", RouteDAO.class);
		List<Favorite> favlist = favDAO.getAll(token);
		
		List<FavoritesList> favList = new ArrayList<FavoritesList>();
		
		for(Favorite f : favlist)
		{
			FavoritesList temp = new FavoritesList();
			String stop = f.getStopId();
			String route = f.getRouteId();
			Stops stop1 = stopDAO.getByStopsAndRoute(stop, route);
			Route route1 = routeDAO.getByRouteID(route);
			EstimatedTime etime =  new EstimatedTime();
			String message = etime.getStops(route, stop).getMessage();
			
			temp.setStreetName(stop1.getStreet());
			temp.setRouteName(route1.getName());
			temp.setRouteId(f.getRouteId());
			temp.setStopId(stop);
			temp.setEstimateTime(message);
			temp.setUserToken(f.getUserToken());
			temp.setTime(f.getTime());
			temp.setEmailFlag(f.getEmailFlag());
			favList.add(temp);
		}
		return favList;	
	}
	
	

}
