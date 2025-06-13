package com.udemy.spring.introduction;

public class Dog implements Pet {
    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

    public void init() {
        System.out.println("Class dog: init method");
    }

    public void destroy() {
        System.out.println("Class dog: destroy method");
    }
}
