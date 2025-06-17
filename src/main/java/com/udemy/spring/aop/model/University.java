package com.udemy.spring.aop.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudent() {
        students.add(new Student("Viktor", 2, 5.6));
        students.add(new Student("Elena", 4, 8.4));
        students.add(new Student("Andrey", 1, 9.0));
    }

    public List<Student> getStudents() {
        System.out.println(students);
        return students;
    }
}
