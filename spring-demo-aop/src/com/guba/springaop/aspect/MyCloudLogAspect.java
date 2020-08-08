package com.guba.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forServicePackageNoGetterSetter()")
    public void logToCloudAsync() {
        LOGGER.info("\n=====> Executing @Before advice on logToCloudAsync One");
    }
}
