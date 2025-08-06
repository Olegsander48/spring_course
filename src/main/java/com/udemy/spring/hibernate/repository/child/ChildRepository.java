package com.udemy.spring.hibernate.repository.child;

import com.udemy.spring.hibernate.entity.Child;

import java.util.Optional;

public interface ChildRepository {
    Optional<Child> findById(int id);

    void save(Child child);
}
