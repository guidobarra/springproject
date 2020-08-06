package com.guba.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.guba.springaop.config.PointcutDeclarationConfig.forServicePackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====> Executing @Before advice on performApiAnalytics Tree");
    }
}
