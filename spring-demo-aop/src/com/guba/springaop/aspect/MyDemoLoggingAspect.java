package com.guba.springaop.aspect;

import com.guba.springaop.domain.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

// Spring AOP using to AspectJ
@Aspect
@Component
public class MyDemoLoggingAspect {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());

    // this is where we add all of our related advices for logging

    // let's start with an @before advice

    // Only method of AccountDAO and not method of MembershipDAO
    @Before("execution(public void com.guba.springaop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() { // Joint Point
        LOGGER.info("\n=====> Executing @Before advice on beforeAddAccountAdvice");
    }

    // For methods that start name with add
    @Before("execution(public void filter*())")
    public void beforeFilterAdvice() {
        LOGGER.info("\n=====> Executing @Before advice on beforeFilterAdvice");
    }

    // For methods that return boolean and start name add
    // equals "boolean add*()" === "* boolean add*()"
    @Before("execution(boolean add*())")
    public void beforeAddAccountAdviceTree() {
        LOGGER.info("\n=====> Executing @Before advice on beforeAddAccountAdviceTree");
    }

    // For methods that start name add and have the first parameter Account and have more one parameter
    // parameter has to be absolute example "com.guba.springaop.domain.Account", no relative example "*Account"
    @Before("execution(* add*(com.guba.springaop.domain.Account, ..))")
    public void beforeAddAccountAdviceFour() {
        LOGGER.info("\n=====> Executing @Before advice on beforeAddAccountAdviceFour");
    }

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forServicePackageNoGetterSetter()")
    public void beforeAddAccountAdviceSix() {
        LOGGER.info("\n=====> Executing @Before advice on beforeAddAccountAdviceSix");
    }

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forControllerPackage()")
    public void beforeAddAccountAdviceSeven() {
        LOGGER.info("\n=====> Executing @Before advice on beforeAddAccountAdviceSeven");
    }

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.onlyMethodAddSillyMember()")
    public void beforeAddSillyMember(JoinPoint joinPoint) {
        LOGGER.info("\n=====> Executing @Before advice on beforeAddSillyMember");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        LOGGER.info("\n=====> Executing @Before methodSignature: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        for (Object arg: args) {
            if (arg instanceof String) {
                LOGGER.info("\n"+arg);
            }
        }
    }

    // if successful
    @AfterReturning(
            pointcut = "com.guba.springaop.config.PointcutDeclarationConfig.onlyMethodGetAccounts()",
            returning = "myVarResult")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> myVarResult) {
        LOGGER.info("\n=====> Executing @Before advice on afterReturningFindAccountsAdvice");

        // print out which method we are advising on
        String nameMethod =  joinPoint.getSignature().toShortString();

        LOGGER.info("\n=====> Executing @Before nameMethod: " + nameMethod);

        // modified
        if (!myVarResult.isEmpty()) {
            myVarResult.get(0).setName("Kioshi");
        }
    }

    // if Throwing
    @AfterThrowing(
            pointcut = "com.guba.springaop.config.PointcutDeclarationConfig.afterExampleThrowing()",
            throwing = "myExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable myExc) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        LOGGER.info("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        LOGGER.info("\n=====>>> The exception is: " + myExc);
    }

    // if Throwing (failure) or if successful
    @After("com.guba.springaop.config.PointcutDeclarationConfig.afterExampleFinally()")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        LOGGER.info("\n=====>>> Executing @After finally on method: " + method);

        // log the exception
        //LOGGER.info("\n=====>>> The exception is: " );
    }

    @Around("com.guba.springaop.config.PointcutDeclarationConfig.aroundExample()")
    public Object afterGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = proceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        LOGGER.info("\n=====>>> Executing: @Around on method: " + proceedingJoinPoint.toString());
        LOGGER.info("\n=====>>> duration: " + duration + " milliseconds");
        return result;
    }

    @Around("com.guba.springaop.config.PointcutDeclarationConfig.aroundExceptionExample()")
    public Object afterGetFortuneParameterBoolean(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            LOGGER.warning(e.getMessage());

            // give user a custom message
            result = "Major accident! But no worries, " +
                    "your private AOP helicopter is on the way!";

            // rethrow exception,
            //throw e;
        }


        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        LOGGER.info("\n=====>>> Executing: @Around on method: " + proceedingJoinPoint.toString());
        LOGGER.info("\n=====>>> duration: " + duration + " milliseconds");
        return result;
    }

    @Around("com.guba.springaop.config.PointcutDeclarationConfig.aroundExceptionExample2()")
    public Object afterGetFortuneParameterInteger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            LOGGER.warning(e.getMessage());

            // rethrow exception, the main driving exception
            throw e;
        }


        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        LOGGER.info("\n=====>>> Executing: @Around on method: " + proceedingJoinPoint.toString());
        LOGGER.info("\n=====>>> duration: " + duration + " milliseconds");
        return result;
    }
}
