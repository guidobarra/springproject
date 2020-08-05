package com.guba.spring;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartNameMethodWithAddAndReturnBooleanApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountDAO the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membershipDAO bean from spring container
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method of accountDAO
        theAccountDAO.addAccountString();

        System.out.println("\n let's call it again!\n");

        // call the business method of membershipDAO again
        theMembershipDAO.addThingMember();

        // close the context
        context.close();
    }
}
