package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Sasha", "Petrov", "IT", 1000);
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
            session.close();
        } finally {
            factory.close();
        }
    }
}
