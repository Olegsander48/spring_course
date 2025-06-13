package com.udemy.spring.introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dogBean")
@Scope("prototype")
public class Dog implements Pet {
    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class dog: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class dog: destroy method");
    }
}
