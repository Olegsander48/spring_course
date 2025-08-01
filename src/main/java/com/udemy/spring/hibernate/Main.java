package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Employee;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        Main main = new Main();
        main.getAll(factory).forEach(System.out::println);
        System.out.println(main.getByName("Sasha", factory));
        factory.close();
    }

    private void getEmployeeById(int id, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.get(Employee.class, id);
        session.getTransaction().commit();
        session.close();
    }

    private List<Employee> getAll(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee");
        List<Employee> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    private Employee getByName(String name, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee where name = :name")
                .setParameter("name", name);
        Employee result = (Employee) query.getResultList().get(0);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    private void addNewEmployee(SessionFactory sessionFactory) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Vladimir", "Vaskob", "HT", 5000);
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
