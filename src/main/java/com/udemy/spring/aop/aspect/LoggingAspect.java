package com.udemy.spring.aop.aspect;

import com.udemy.spring.aop.library.UniLibrary;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(UniLibrary.class.getName());

    @Before("com.udemy.spring.aop.aspect.MyPointcut.pointcutReference()")
    public void beforeGetLoggingAdvice(JoinPoint joinPoint) {
        LOG.info("Вызван метод:  LoggingAspect.beforeGetLoggingAdvice()");
        LOG.info("" + joinPoint.getSignature());
    }
}
