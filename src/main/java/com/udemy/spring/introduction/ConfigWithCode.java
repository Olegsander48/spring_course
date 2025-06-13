package com.udemy.spring.introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigWithCode {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }
}
