package com.udemy.spring.aop.libraries;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("Берем книгу из школьной библиотеки");
    }
}
