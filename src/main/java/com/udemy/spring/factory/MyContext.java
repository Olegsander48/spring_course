package com.udemy.spring.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(CarConfig.class);
        String carModel = context.getBean("car", String.class);
        System.out.println(carModel);
    }
}
