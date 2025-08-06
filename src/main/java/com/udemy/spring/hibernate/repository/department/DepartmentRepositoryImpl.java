package com.udemy.spring.hibernate.repository.department;

import com.udemy.spring.hibernate.entity.Department;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private SessionFactory sessionFactory;

    @Override
    public Optional<Department> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Optional<Department> department = Optional.ofNullable(session.get(Department.class, id));
        session.getTransaction().commit();
        session.close();
        return department;
    }

    @Override
    public void save(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(department);
        session.getTransaction().commit();
        session.close();
    }
}
