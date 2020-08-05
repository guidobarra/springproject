package com.guba.spring;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.dao.MembershipDAO;
import com.guba.springaop.domain.Account;
import com.guba.springaop.service.AccountService;
import com.guba.springaop.service.MembershipService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllMethodOfPackageService {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountDAO the bean from spring container
        AccountService accountService = context.getBean("accountService", AccountService.class);

        // get membershipDAO bean from spring container
        MembershipService membershipService = context.getBean("membershipService", MembershipService.class);

        // call the business method of accountDAO
        accountService.findAccount();

        System.out.println("\n let's call it again!\n");

        // call the business method of accountDAO again
        accountService.findAccountParameter(new Account("name","level"), false);

        // call the business method of membershipDAO
        membershipService.findSillyMember();

        System.out.println("\n let's call it again!\n");

        // call the business method of membershipDAO again
        membershipService.findThingMember();

        // close the context
        context.close();
    }
}
