package peopleMoverWS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverDB.dao.StopsDAO;
import peopleMoverDB.dao.WayPointsDAO;
import peopleMoverDB.model.Stops;
import peopleMoverDB.model.StopsWithWP;
import peopleMoverDB.model.WayPoints;


@RestController
public class StopsWithWPController {
	@RequestMapping("/getstopwaypoints")
	public List<?> getStopWayPoints(@RequestParam(value="RouteId", required=true) String RouteId) 
	{
		List<StopsWithWP> stopList = getStopWayPointsCx(RouteId);
		return stopList ;
	}
	private List<StopsWithWP> getStopWayPointsCx(String RouteId)
	{
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//To use JdbcTemplate
		StopsDAO stopsDAO = ctx.getBean("StopsDAOJDBCTemplate", StopsDAO.class);
		WayPointsDAO wayDAO = ctx.getBean("WayPointsDAOJDBCTemplate", WayPointsDAO.class);
		
		List<StopsWithWP> liststopWP = new ArrayList<StopsWithWP>();
		List<Stops> liststop = stopsDAO.getListByRouteID(RouteId);
		
		for (Stops stops : liststop) {
			List<WayPoints> listwaypoint = wayDAO.getListByRouteANDStop(stops.getStopId(),RouteId);
			StopsWithWP currentStop = new StopsWithWP();
			currentStop.setStopId(stops.getStopId());
			currentStop.setRouteId(stops.getRouteId());
			currentStop.setStreet(stops.getStreet());
			currentStop.setScheduledTime(stops.getScheduledTime());
			currentStop.setLatitude(stops.getLatitude());
			currentStop.setLongitude(stops.getLongitude());
			currentStop.setListwp(listwaypoint);
			liststopWP.add(currentStop);
		}
		return liststopWP;
	}

}
