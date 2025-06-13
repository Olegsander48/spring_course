package com.udemy.spring.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Cat cat = context.getBean("catBean", Cat.class);
        cat.say();

        context.close();
    }
}
