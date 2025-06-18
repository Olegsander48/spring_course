package com.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("com.udemy.spring.aop.aspect.MyPointcut.pointcutReference()")
    public void beforeGetExceptionHandlingAdvice() {
        System.out.println("Catch exception while get book/magazine");
    }
}
