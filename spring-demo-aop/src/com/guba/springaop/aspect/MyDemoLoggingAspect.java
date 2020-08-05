package com.guba.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdvice");
    }

    // For methods that start name with add
    @Before("execution(public void add*())")
    public void beforeAddAccountAdviceTwo() {
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdviceTwo");
    }

    // For methods that return void and start name add
    // equals "void add*()" === "* void add*()"
    @Before("execution(boolean add*())")
    public void beforeAddAccountAdviceTree() {
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdviceTree");
    }

    // For methods that start name add and have the first parameter Account and have more one parameter
    // parameter has to be absolute example "com.guba.springaop.domain.Account", no relative example "*Account"
    @Before("execution(* add*(com.guba.springaop.domain.Account, ..))")
    public void beforeAddAccountAdviceFour() {
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdviceFour");
    }

    // create Pointcut for all methods of all class of package service
    @Pointcut("execution(* com.guba.springaop.service.*.*(..))")
    private void forServicePackage(){}

    // create Pointcut for getter methods
    @Pointcut("execution(* com.guba.springaop.service.*.get*(..))")
    private void getter(){}

    // create Pointcut for setter methods
    @Pointcut("execution(* com.guba.springaop.service.*.set*(..))")
    private void setter(){}

    // combine Pointcut: include package and exclude getter and setter
    @Pointcut("forServicePackage() && !(setter() || getter())")
    private void forServicePackageNoGetterSetter(){}

    @Before("com.guba.springaop.aspect.MyDemoLoggingAspect.forServicePackage()")
    public void beforeAddAccountAdviceFive() {
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdviceFive");
    }

    @Before("com.guba.springaop.aspect.MyDemoLoggingAspect.forServicePackageNoGetterSetter()")
    public void beforeAddAccountAdviceSix() {
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdviceSix");
    }
}
