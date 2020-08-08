package com.guba.springaop.main;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class OnlyMethodAddAccountOfAccountDAO {

    private static final Logger LOGGER = Logger.getLogger(OnlyMethodAddAccountOfAccountDAO.class.getName());

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

        LOGGER.info("\n let's call it again!\n");

        // call the business method of accountDAO again
        theAccountDAO.addAccount();

        LOGGER.info("\n let's call it again!\n");

        // call the business method of membershipDAO
        theMembershipDAO.addAccount();

        LOGGER.info("\n let's  no call it again!\n");

        // call the business method of membershipDAO again
        theMembershipDAO.addAccount();

        // close the context
        context.close();
    }
}
