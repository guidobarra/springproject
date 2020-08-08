package com.guba.springaop.main;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.domain.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AfterFinallyApp {

    private static final Logger LOGGER = Logger.getLogger(AfterFinallyApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = new ArrayList<>();

        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = false;
            theAccounts = theAccountDAO.mapReduceAccounts(tripWire);
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
