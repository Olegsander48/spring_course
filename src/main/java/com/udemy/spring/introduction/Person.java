package com.udemy.spring.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;
    private String surname;
    private int age;

    /**
     * We don't have to write @Autowired, because there is only 1 constructor
     * @param pet automatically created Bean Cat
     */
    @Autowired
    public Person(@Qualifier("catBean") Pet pet) {
        this.pet = pet;
        System.out.println("constructor worked");
        pet.say();
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely pet!");
        pet.say();
    }

    @Autowired
    @Qualifier("dogBean")
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
