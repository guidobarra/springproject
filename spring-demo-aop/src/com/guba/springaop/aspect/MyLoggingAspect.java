package com.guba.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forServicePackageNoGetterSetter()")
    public void myLoggingAspect() {
        LOGGER.info("\n=====> Executing @Before advice on myLoggingAspect Two");
    }

}
