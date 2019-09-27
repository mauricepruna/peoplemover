package peopleMoverWS.util;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import peopleMoverDB.dao.LocationDAO;
import peopleMoverDB.dao.UnitDAO;
import peopleMoverDB.dao.UserDAO;
import peopleMoverWS.controller.LocationController;
import peopleMoverWS.controller.UnitListController;
import peopleMoverWS.model.Location;
import peopleMoverWS.model.Unit;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class TSOLookupService extends Service{

	
	@Scheduled(cron="${cronexpression}")
    public void ServiceMethod()
    {
        System.out.println("Method executed at every 10 seconds. Current time is :: "+ new Date());
//		UnitListController unitListCont = new UnitListController();
//		List<Unit> unitlist = (List<Unit>) unitListCont.getunitlist();
//		
//		LocationController locCont = new LocationController();
//		
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		UnitDAO unitDAO = ctx.getBean("UnitDAOJDBCTemplate", UnitDAO.class);
//		LocationDAO locationDAO = ctx.getBean("LocationDAOJDBCTemplate", LocationDAO.class);
//		for (Unit unit : unitlist) {
//			Unit newUnit = null;
//			try {
//				newUnit=unitDAO.getByID(unit.getID());
//			} catch (EmptyResultDataAccessException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			finally{
//				if(newUnit == null)
//				{
//					try {
//						unitDAO.save(unit);
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}	
//			}
//			Location loc = locCont.getLocation(unit.getUnitID());
//			Location dbLoc=null;
//			try {
//				dbLoc = locationDAO.getByUnitIDAndDateTime(loc.getUnitID(), loc.getLastEventDate());
//			} catch (EmptyResultDataAccessException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			finally
//			{
//				if(dbLoc == null)
//				{
//					try {
//						locationDAO.save(loc);
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		ctx.close();
		
    }
}
