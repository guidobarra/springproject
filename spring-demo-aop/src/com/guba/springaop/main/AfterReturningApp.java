package com.guba.springaop.main;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.domain.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AfterReturningApp {

    private static final Logger LOGGER = Logger.getLogger(AfterReturningApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountService the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method of accountService
        List<Account> accounts = accountDAO.getAccounts();
        // print out the myVarResult of the method call
        LOGGER.info("\nResult Modified: " + accounts);
        // close the context
        context.close();
    }
}
