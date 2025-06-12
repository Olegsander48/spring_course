package com.udemy.spring.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet dog = context.getBean("myDog", Dog.class);
        dog.say();
        Pet cat = context.getBean("myCat", Cat.class);
        cat.say();
        context.close();
    }
}
