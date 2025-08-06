package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "section")
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"), //column in join table
            inverseJoinColumns = @JoinColumn(name = "child_id")) //column that will connect out table to other table
    private List<Child> children;

    public Section(String name) {
        this.name = name;
    }

    public void addChild(Child child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }
}
