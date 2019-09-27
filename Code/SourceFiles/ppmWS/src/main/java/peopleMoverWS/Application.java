package peopleMoverWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import peopleMoverWS.util.AlarmService;
import peopleMoverWS.util.TSOLookupService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    	
        //ApplicationContext appcontext = SpringApplication.run(Application.class, args);
        //TSOLookupService tso = appcontext.getBean(TSOLookupService.class);
       SpringApplication.run(new Object[]{Application.class, AlarmService.class, TSOLookupService.class}, args);
    	//ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}