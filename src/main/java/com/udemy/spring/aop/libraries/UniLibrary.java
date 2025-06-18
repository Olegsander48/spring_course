package com.udemy.spring.aop.libraries;

import com.udemy.spring.aop.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UniLibrary extends AbstractLibrary {
    private List<Book> books = new ArrayList<>();
    
    @Override
    public void getBook() {
        System.out.println("Берем книгу из библиотеки университета");
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга " + book.getName() + " добавлена в университетскую библиотеку");
    }

    public String returnBook() {
        return books.get(0).getName();
    }
}
