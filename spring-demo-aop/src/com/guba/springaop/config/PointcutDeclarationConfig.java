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

    // create Pointcut for all methods of all class of package controller
    @Pointcut("execution(* com.guba.springaop.dao.MembershipDAO.addSillyMember(..))")
    public void onlyMethodAddSillyMember(){}
}
