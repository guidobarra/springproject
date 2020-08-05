package com.guba.spring;

import com.guba.springaop.config.DemoConfig;
import com.guba.springaop.dao.AccountDAO;
import com.guba.springaop.dao.MembershipDAO;
import com.guba.springaop.domain.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartNameMethodWithAddAndParameterApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get accountDAO the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method of accountDAO
        theAccountDAO.addAccountParameter(new Account("name", "2"), false);

        // close the context
        context.close();
    }
}
