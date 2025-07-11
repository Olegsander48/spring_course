package com.udemy.spring.aop.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("${book.name}")
    private String name;
    @Value("${book.author}")
    private String author;
    @Value("${book.yearOfPublication}")
    private int yearOfPublication;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
