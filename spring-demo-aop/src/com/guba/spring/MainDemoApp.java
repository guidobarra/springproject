package com.guba.spring;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountDAO the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membershipDAO bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method of accountDAO
        theAccountDAO.addAccount();

        System.out.println("\n let's call it again!\n");

        // call the business method of accountDAO again
        theAccountDAO.addAccount();

        // call the business method of membershipDAO
        theMembershipDAO.addAccount();

        System.out.println("\n let's call it again!\n");

        // call the business method of membershipDAO again
        theMembershipDAO.addAccount();

        // close the context
        context.close();
    }
}
