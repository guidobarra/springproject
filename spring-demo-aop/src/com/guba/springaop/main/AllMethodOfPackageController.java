package com.guba.springaop.main;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.controller.AccountController;
import com.guba.springaop.controller.MembershipController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AllMethodOfPackageController {

    private static final Logger LOGGER = Logger.getLogger(AllMethodOfPackageController.class.getName());
    
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountDAO the bean from spring container
        AccountController accountController = context.getBean("accountController", AccountController.class);

        // get membershipDAO bean from spring container
        MembershipController membershipController = context.getBean("membershipController", MembershipController.class);

        // call the business method of accountDAO
        accountController.setStatus("status");

        LOGGER.info("\n let's call it again!\n");

        // call the business method of accountDAO again
        accountController.getAccount();

        LOGGER.info("\n let's call it again!\n");

        // call the business method of membershipDAO
        membershipController.findMembershipController();

        LOGGER.info("\n let's call it again!\n");

        // call the business method of membershipDAO again
        membershipController.getStatus();

        // close the context
        context.close();
    }
}
