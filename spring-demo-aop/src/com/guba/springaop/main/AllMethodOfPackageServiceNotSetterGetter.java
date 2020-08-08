package com.guba.springaop.main;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.domain.Account;
import com.guba.springaop.service.AccountService;
import com.guba.springaop.service.MembershipService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AllMethodOfPackageServiceNotSetterGetter {

    private static final Logger LOGGER = Logger.getLogger(AllMethodOfPackageServiceNotSetterGetter.class.getName());
    
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountService the bean from spring container
        AccountService accountService = context.getBean("accountService", AccountService.class);

        // get membershipService bean from spring container
        MembershipService membershipService = context.getBean("membershipService", MembershipService.class);

        // call the business method of accountService
        accountService.findAccount();

        LOGGER.info("\n let's call it again!\n");

        // call the business method of accountService again
        accountService.findAccountParameter(new Account("name","level"), false);

        LOGGER.info("\n let's call it again!\n");

        // call the business method of accountService get
        accountService.getPass();

        LOGGER.info("\n let's call it again!\n");

        // call the business method of accountService set
        accountService.setPass("asd");

        // close the context
        context.close();
    }
}
