package com.guba.springaop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// queria tener una clase en el cual tenga todos Pointcut y otra que los utilice y escriba el metodo, no me deja
@Aspect
public class PointcutDeclarationConfig {

    // create Pointcut for all methods of all class of package controller
    @Pointcut("execution(* com.guba.springaop.controller.*.*(..))")
    public void forControllerPackage(){}

    // create Pointcut for all methods of all class of package service
    @Pointcut("execution(* com.guba.springaop.service.*.*(..))")
    public void forServicePackage(){}

    // create Pointcut for getter methods
    @Pointcut("execution(* com.guba.springaop.service.*.get*(..))")
    public void getter(){}

    // create Pointcut for setter methods
    @Pointcut("execution(* com.guba.springaop.service.*.set*(..))")
    public void setter(){}

    // combine Pointcut: include package and exclude getter and setter
    @Pointcut("forServicePackage() && !(setter() || getter())")
    public void forServicePackageNoGetterSetter(){}

    // create Pointcut for only methods addSillyMember of class MembershipDAO
    @Pointcut("execution(* com.guba.springaop.dao.MembershipDAO.addSillyMember(..))")
    public void onlyMethodAddSillyMember(){}

    // create Pointcut for only methods getAccounts of class AccountDAO
    @Pointcut("execution(* com.guba.springaop.dao.AccountDAO.getAccounts(..))")
    public void onlyMethodGetAccounts(){}

    // create Pointcut for only methods findAccounts of class AccountDAO
    @Pointcut("execution(* com.guba.springaop.dao.AccountDAO.findAccounts(..))")
    public void afterExampleThrowing(){}

    // create Pointcut for only methods mapReduceAccounts of class AccountDAO
    @Pointcut("execution(* com.guba.springaop.dao.AccountDAO.mapReduceAccounts(..))")
    public void afterExampleFinally(){}
}
