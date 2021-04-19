package com.marcos.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect
{
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.marcos.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.marcos.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.marcos.springdemo.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint)
    {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("In @Before advice: calling method: " + method);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArgs : args)
        {
            myLogger.info("=====> Argument here: "+ tempArgs);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void AfterReturning(JoinPoint theJoinPoint, Object theResult)
    {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("====>> in @afterReturning: from method " + method);

        myLogger.info("======>> The result here: " + theResult);
    }



}
