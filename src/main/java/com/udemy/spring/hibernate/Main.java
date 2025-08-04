package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.configuration.Factory;
import com.udemy.spring.hibernate.entity.Employee;
import com.udemy.spring.hibernate.repository.EmployeeRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Factory.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        Employee employee = new Employee("Vladimir", "Vaskob", "HT", 5000);
        employeeRepository.save(employee);
        System.out.println(employeeRepository.findById(employee.getId()).get());

        employeeRepository.deleteById(6);
    }
}
