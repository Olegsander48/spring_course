package com.udemy.spring.hibernate.repository.secion;

import com.udemy.spring.hibernate.entity.Section;

import java.util.Optional;

public interface SectionRepository {
    Optional<Section> findById(int id);

    void save(Section section);
}
