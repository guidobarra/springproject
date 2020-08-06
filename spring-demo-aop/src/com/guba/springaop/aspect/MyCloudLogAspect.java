package com.guba.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forServicePackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n=====> Executing @Before advice on logToCloudAsync One");
    }
}
