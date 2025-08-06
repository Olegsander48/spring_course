package com.udemy.spring.hibernate.repository.child;

import com.udemy.spring.hibernate.entity.Child;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ChildRepositoryImpl implements ChildRepository {
    private SessionFactory sessionFactory;

    @Override
    public Optional<Child> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Optional<Child> child = Optional.ofNullable(session.get(Child.class, id));
        session.getTransaction().commit();
        session.close();
        return child;
    }

    @Override
    public void save(Child child) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(child);
        session.getTransaction().commit();
        session.close();
    }
}
