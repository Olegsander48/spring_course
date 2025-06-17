package com.udemy.spring.aop.aspects;

import com.udemy.spring.aop.libraries.UniLibrary;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {
    private static final Logger LOG = LoggerFactory.getLogger(UniLibrary.class.getName());

    @Pointcut("execution(* get*())")
    private void pointcutReference() { }

    @Before("pointcutReference()")
    public void beforeGetLoggingAdvice() {
        LOG.info("Вызван метод:  LoggingAspect.beforeGetLoggingAdvice()");
    }

    @Before("pointcutReference()")
    public void beforeGetSecurityAdvice() {
        LOG.info("Вызван метод: LoggingAspect.beforeGetSecurityAdvice()");
        LOG.info("Проверка прав доступа");
    }
}
