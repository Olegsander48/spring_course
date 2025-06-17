package com.udemy.spring.aop.libraries;

import com.udemy.spring.aop.model.Book;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("Берем книгу из библиотеки университета");
    }

    public void addBook(Book book) {
        System.out.println("Книга " + book.getName() + " добавлена в университетскую библиотеку");
    }

    public void getMagazine() {
        System.out.println("Берем журнал из библиотеки университета");
    }
}
