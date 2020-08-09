package com.guba.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private final Logger LOGGER = Logger.getLogger(getClass().getName());
	
	// setup point declarations
	
	// do the same for controller
	@Pointcut("execution(* com.guba.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same for service
	@Pointcut("execution(* com.guba.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	// do the same for dao
	@Pointcut("execution(* com.guba.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	// do the same for dao
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		LOGGER.info("====> in  @Before: calling method: "+theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			LOGGER.info("====> argument: " + arg);
		}
		
	}
	
	// add @AfterReturning Advice
	@AfterReturning(
				pointcut = "forAppFlow()",
				returning = "myReturn") 
	public void afterReturing(JoinPoint joinPoint, Object myReturn) {
		
		// display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		LOGGER.info("====> in  @AfterReturning: calling method: "+theMethod);
		
		// display data returned
		LOGGER.info("====> result: " + myReturn);
	}
	
	
	
	
}
