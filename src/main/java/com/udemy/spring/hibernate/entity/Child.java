package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "children")
@NoArgsConstructor
@AllArgsConstructor
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "child_id"), //column in join table
            inverseJoinColumns = @JoinColumn(name = "section_id")) //column that will connect out table to other table
    private List<Section> sections;

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addSection(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);
    }
}
