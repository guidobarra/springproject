package com.guba.springaop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// queria tener una clase en el cual tenga todos Pointcut y otra que los utilice y escriba el metodo, no me deja
@Aspect
@Component
public class PointcutDeclarationConfig {

    @Pointcut("execution(* com.guba.springaop.service.*.*(..))")
    private void forServicePackage(){}
}
