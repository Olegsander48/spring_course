package com.udemy.spring.aop.libraries;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("Берем книгу из библиотеки университета");
    }

    public void returnBook() {
        System.out.println("Возвращаем книгу в библиотеку университета");
    }

    public void getMagazine(String magazineName) {
        System.out.println("Берем журнал " + magazineName + " из библиотеки университета");
    }
}
