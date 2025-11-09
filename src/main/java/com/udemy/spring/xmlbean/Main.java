package com.udemy.spring.xmlbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("xmlApplicationContext.xml");
        Repository repository = context.getBean("memoryRepository", Repository.class);
        repository.show();

        context.close();
    }
}
