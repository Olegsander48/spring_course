package com.udemy.spring.aop;

import com.udemy.spring.aop.libraries.SchoolLibrary;
import com.udemy.spring.aop.libraries.UniLibrary;
import com.udemy.spring.aop.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        Book book = context.getBean("book", Book.class);
        uniLibrary.addBook(book);

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();

        context.close();
    }
}
