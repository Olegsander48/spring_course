package com.udemy.spring.introduction;

public class Person {
    private Pet pet;

    public Person() {
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely pet!");
        pet.say();
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
