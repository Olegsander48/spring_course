package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column
    private String surname;
    @Column
    private String department;
    @Column
    private int salary;

    @OneToOne(cascade = CascadeType.ALL) //when delete employee his details will be deleted
    @JoinColumn(name = "detail_id") //column from current table
    private Detail employeeDetail;

    @ManyToOne(cascade = CascadeType.ALL) //FK in many table
    @JoinColumn(name = "department_id") //column from current table, FK
    private Department departmentDetail;

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }
}

