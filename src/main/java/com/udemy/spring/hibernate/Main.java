package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.configuration.Factory;
import com.udemy.spring.hibernate.entity.Department;
import com.udemy.spring.hibernate.entity.Detail;
import com.udemy.spring.hibernate.entity.Employee;
import com.udemy.spring.hibernate.repository.department.DepartmentRepository;
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
    }
}
