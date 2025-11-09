package com.udemy.spring.xmlbean;

public class HibernateRepository implements Repository {
    @Override
    public void show() {
        System.out.println("HibernateRepository");
    }
}
