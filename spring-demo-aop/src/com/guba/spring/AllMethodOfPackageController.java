package com.guba.spring;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.controller.AccountController;
import com.guba.springaop.controller.MembershipController;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.dao.MembershipDAO;
import com.guba.springaop.domain.Account;
import com.guba.springaop.service.AccountService;
import com.guba.springaop.service.MembershipService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllMethodOfPackageController {
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

        System.out.println("\n let's call it again!\n");

        // call the business method of accountDAO again
        accountController.getAccount();

        System.out.println("\n let's call it again!\n");

        // call the business method of membershipDAO
        membershipController.findMembershipController();

        System.out.println("\n let's call it again!\n");

        // call the business method of membershipDAO again
        membershipController.getStatus();

        // close the context
        context.close();
    }
}
