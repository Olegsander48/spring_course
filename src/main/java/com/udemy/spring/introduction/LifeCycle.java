package com.udemy.spring.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Pet pet = context.getBean("myPet", Dog.class);
        pet.say();
        context.close();
    }
}
