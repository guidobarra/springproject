package com.guba.springaop.main;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.TrafficFortuneDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static final Logger LOGGER = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneDAO trafficFortuneDAO = context.getBean("trafficFortuneDAO", TrafficFortuneDAO.class);

        LOGGER.info("Calling getFortune\n");

        boolean tripWire = true;
        String data = trafficFortuneDAO.getFortune(tripWire);

        // display the accounts
        LOGGER.info("\nMy fortune is: " + data);

        LOGGER.info("\nFinished");

        // close the context
        context.close();
    }
}
