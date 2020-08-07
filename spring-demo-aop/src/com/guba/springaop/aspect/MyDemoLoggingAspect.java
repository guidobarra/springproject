package com.guba.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

// Spring AOP using to AspectJ
@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @before advice

    // Only method of AccountDAO and not method of MembershipDAO
    @Before("execution(public void com.guba.springaop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() { // Joint Point
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdvice");
    }

    // For methods that start name with add
    @Before("execution(public void filter*())")
    public void beforeFilterAdvice() {
        System.out.println("\n=====> Executing @Before advice on beforeFilterAdvice");
    }

    // For methods that return boolean and start name add
    // equals "boolean add*()" === "* boolean add*()"
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

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forServicePackageNoGetterSetter()")
    public void beforeAddAccountAdviceSix() {
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdviceSix");
    }

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forControllerPackage()")
    public void beforeAddAccountAdviceSeven() {
        System.out.println("\n=====> Executing @Before advice on beforeAddAccountAdviceSeven");
    }

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.onlyMethodAddSillyMember()")
    public void beforeAddSillyMember(JoinPoint joinPoint) {
        System.out.println("\n=====> Executing @Before advice on beforeAddSillyMember");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("\n=====> Executing @Before methodSignature: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        for (Object arg: args) {
            if (arg instanceof String) {
                System.out.println("\n"+arg);
            }
        }
    }
}
