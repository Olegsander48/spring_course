package com.udemy.spring.configurations;

import com.udemy.spring.configurations.config.DbConfig;
import com.udemy.spring.configurations.config.SecurityConfig;
import com.udemy.spring.configurations.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SeveralConfigs {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DbConfig.class, SecurityConfig.class);
        Person person1 = context.getBean("getPerson", Person.class);
        Person person2 = context.getBean("getPerson", Person.class);
        System.out.println(person1);
        System.out.println(person2);
    }
}
