package com.guba.spring;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.controller.AccountController;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.dao.MembershipDAO;
import com.guba.springaop.service.MembershipService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartNameMethodWithFilterApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountDAO the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membershipDAO bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // get membershipDAO bean from spring container
        AccountController accountController = context.getBean("accountController", AccountController.class);

        // call the business method of accountDAO
        theAccountDAO.filterAccountDAO();

        System.out.println("\n let's call it again!\n");

        // call the business method of membershipDAO
        theMembershipDAO.filterMembership();

        System.out.println("\n let's call it again!\n");

        // call the business method of membershipDAO again
        accountController.filterAccountController();

        System.out.println("\n let's no call it again!\n");
        theAccountDAO.noCallMethodsAspect();
        theMembershipDAO.noCallMethodsAspect();
        // close the context
        context.close();
    }
}
