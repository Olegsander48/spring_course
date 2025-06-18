package com.udemy.spring.aop;

import com.udemy.spring.aop.config.MyConfig;
import com.udemy.spring.aop.model.University;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);
        University university = context.getBean("university", University.class);
        university.addStudent();
        try {
            System.out.println(university.getStudents());
        } catch (Exception e) {
            System.out.println("Catch IndexOutOfBoundException");
        }
        context.close();
    }
}
