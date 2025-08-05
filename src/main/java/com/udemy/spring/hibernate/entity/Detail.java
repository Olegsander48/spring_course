package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "details")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "employeeDetail", cascade = CascadeType.ALL)
            //one to one already exist, find it in Employee in field empDetail
    private Employee employee;

    public Detail(String email, String phoneNumber, String city) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }
}
