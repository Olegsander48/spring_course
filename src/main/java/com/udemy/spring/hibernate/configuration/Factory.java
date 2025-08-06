package com.udemy.spring.hibernate.configuration;

import com.udemy.spring.hibernate.entity.Department;
import com.udemy.spring.hibernate.entity.Detail;
import com.udemy.spring.hibernate.entity.Employee;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.udemy.spring.hibernate")
public class Factory {
    @Bean
    public SessionFactory getSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
    }
}
