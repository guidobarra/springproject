package com.guba.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Spring AOP using to AspectJ
@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @before advice

    // Only method of AccountDAO and not method of MembershipDAO
    @Before("execution(public void com.guba.springaop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }

    // For methods that start name with add
    @Before("execution(public void add*())")
    public void beforeAddAccountAdviceTwo() {
        System.out.println("\n=====> Executing @Before advice on addAccount() Two");
    }

    // For methods that return void and start name add
    // equals "void add*()" === "* void add*()"
    @Before("execution(boolean add*())")
    public void beforeAddAccountAdviceTree() {
        System.out.println("\n=====> Executing @Before advice on addAccount() Tree");
    }
}
