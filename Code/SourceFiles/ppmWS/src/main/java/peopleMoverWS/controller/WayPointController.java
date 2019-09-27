package peopleMoverWS.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverDB.dao.WayPointsDAO;

import peopleMoverDB.model.WayPoints;


@RestController
public class WayPointController {
	@RequestMapping("/getwaypoints")
	public List<?> getWayPoints(@RequestParam(value="StopId", required=true) String StopId,@RequestParam(value="RouteId", required=true) String RouteId) 
	{
		List<WayPoints> stopList = getWayPointsCx(StopId,RouteId);
		return stopList ;
	}
	private List<WayPoints> getWayPointsCx(String StopId,String RouteId)
	{
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//To use JdbcTemplate
		WayPointsDAO wayDAO = ctx.getBean("WayPointsDAOJDBCTemplate", WayPointsDAO.class);
		List<WayPoints> listwaypoint = wayDAO.getListByRouteANDStop(StopId,RouteId);
		return listwaypoint;
	}
}
