package com.udemy.spring.aop;

import com.udemy.spring.aop.libraries.UniLibrary;
import com.udemy.spring.aop.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        library.addBook(context.getBean("book", Book.class));
        System.out.println(library.returnBook());
        context.close();
    }
}
