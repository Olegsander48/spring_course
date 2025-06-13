package com.udemy.spring.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Person {
    private Pet pet;
    private Pet youngerPet;
    @Value("${person.surname}")
    private String surname;
    @Value("33")
    private int age;


    /**
     * We don't have to write @Autowired, because there is only 1 constructor
     * @param pet automatically created Bean Cat
     */
    @Autowired
    public Person(@Qualifier("catBean") Pet pet) {
        this.pet = pet;
    }

    public Person(Pet pet1, Pet pet2) {
        this.pet = pet1;
        this.youngerPet = pet2;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely pet!");
        pet.say();
        youngerPet.say();
    }

/*    @Autowired
    public void setPet(@Qualifier("dogBean") Pet pet, @Qualifier("catBean") Pet youngerPet) {
        this.pet = pet;
        this.youngerPet = youngerPet;
    }*/

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
