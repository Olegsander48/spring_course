package com.udemy.spring.hibernate.repository.employee;

import com.udemy.spring.hibernate.entity.Employee;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private SessionFactory factory;

    @Override
    public Optional<Employee> findById(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Optional<Employee> employee = Optional.ofNullable(session.get(Employee.class, id));
        session.getTransaction().commit();
        session.close();

        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee");
        List<Employee> result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public Optional<Employee> findByName(String name) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee where name = :name")
                .setParameter("name", name);
        Optional<Employee> result = Optional.ofNullable((Employee) query.getSingleResult());
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void save(Employee employee) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteById(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.remove(session.get(Employee.class, id));
        session.getTransaction().commit();
        session.close();
    }
}
