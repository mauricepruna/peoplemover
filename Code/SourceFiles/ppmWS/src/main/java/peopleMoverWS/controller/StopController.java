package peopleMoverWS.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import peopleMoverDB.dao.StopsDAO;
import peopleMoverDB.model.Stops;


@RestController
public class StopController {
	@RequestMapping("/getstops")
	public List<?> getStops(@RequestParam(value="RouteId", required=true) String RouteId) 
	{
		List<Stops> stopList = getStopsCx(RouteId);
		return stopList ;
	}
	private List<Stops> getStopsCx(String RouteId)
	{
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//To use JdbcTemplate
		StopsDAO stopsDAO = ctx.getBean("StopsDAOJDBCTemplate", StopsDAO.class);
		List<Stops> liststop = stopsDAO.getListByRouteID(RouteId);
		return liststop;
	}
}
