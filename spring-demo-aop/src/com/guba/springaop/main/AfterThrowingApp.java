package com.guba.springaop.main;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.domain.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AfterThrowingApp {

    private static final Logger LOGGER = Logger.getLogger(AfterThrowingApp.class.getName());
    
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = null;

        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception exc) {
            LOGGER.info("\n\nMain Program ... caught exception: " + exc);
        }

        // display the accounts
        LOGGER.info("\n\nMain Program: AfterThrowingDemoApp");
        LOGGER.info("----");

        LOGGER.info(theAccounts.toString());

        LOGGER.info("\n");

        // close the context
        context.close();
    }
}
