package com.saydin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAnnotationExecutionTime {

    Logger logger= LoggerFactory.getLogger(CustomAnnotationExecutionTime.class);

    @Around("@annotation(com.saydin.aop.CustomExecutionTime)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object obj= joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        logger.info((endTime-startTime) +" " +joinPoint.getSignature());
        return  obj;
    }
}
