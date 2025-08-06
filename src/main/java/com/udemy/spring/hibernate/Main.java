package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.configuration.Factory;
import com.udemy.spring.hibernate.entity.*;
import com.udemy.spring.hibernate.repository.child.ChildRepository;
import com.udemy.spring.hibernate.repository.department.DepartmentRepository;
import com.udemy.spring.hibernate.repository.secion.SectionRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Factory.class);
        DepartmentRepository repository = context.getBean(DepartmentRepository.class);

        Employee employee1 = new Employee("Vladimir", "Vaskob", "HT", 5000);
        Detail detail = new Detail("test@gmail.com", "8029777777", "Minsk");
        employee1.setEmployeeDetail(detail);
        detail.setEmployee(employee1);

        Employee employee2 = new Employee("Maks", "Jakobs", "NTT", 800);
        Department department = new Department("IT", 1000, 7000);
        department.addEmployeeToDepartment(employee1);
        department.addEmployeeToDepartment(employee2);

        repository.save(department);
        System.out.println(repository.findById(department.getId()));

        //new section about many-to-many

        Section section = new Section("Football");
        Child child1 = new Child("Maksim", 7);
        Child child2 = new Child("Andrey", 3);
        Child child3 = new Child("Nikita", 15);
        section.addChild(child1);
        section.addChild(child2);
        section.addChild(child3);

        SectionRepository sectionRepository = context.getBean(SectionRepository.class);
        sectionRepository.save(section);
        System.out.println(sectionRepository.findById(section.getId()));

        Child child = new Child("Maksim", 7);
        Section section1 = new Section("Football");
        Section section2 = new Section("Chess");
        Section section3 = new Section("Swimming");
        child.addSection(section1);
        child.addSection(section2);
        child.addSection(section3);

        ChildRepository childRepository = context.getBean(ChildRepository.class);
        childRepository.save(child);
        System.out.println(childRepository.findById(child.getId()));
    }
}
