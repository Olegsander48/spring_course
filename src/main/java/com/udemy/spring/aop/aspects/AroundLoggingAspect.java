package com.udemy.spring.aop.aspects;

import com.udemy.spring.aop.libraries.UniLibrary;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundLoggingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(UniLibrary.class.getName());

    @Around("execution(public String returnBook())")
    public String aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOG.info("Work of aroundReturnBookLoggingAdvice method: returning book");
        return (String) proceedingJoinPoint.proceed();
    }

}
