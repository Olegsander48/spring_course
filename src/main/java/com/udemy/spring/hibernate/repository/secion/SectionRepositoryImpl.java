package com.udemy.spring.hibernate.repository.secion;

import com.udemy.spring.hibernate.entity.Section;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class SectionRepositoryImpl implements SectionRepository {
    private SessionFactory sessionFactory;

    @Override
    public Optional<Section> findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Optional<Section> section = Optional.ofNullable(session.get(Section.class, id));
        session.getTransaction().commit();
        session.close();
        return section;
    }

    @Override
    public void save(Section section) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(section);
        session.getTransaction().commit();
        session.close();
    }
}
