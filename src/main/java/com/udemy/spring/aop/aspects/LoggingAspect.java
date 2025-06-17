package com.udemy.spring.aop.aspects;

import com.udemy.spring.aop.Library;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(Library.class.getName());

    @Before("execution(public void getBook())")
    public void beforeGetBookAdvice() {
        LOG.info("Вызван метод:  LoggingAspect.beforeGetBookAdvice()");
    }
}
