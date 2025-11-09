package com.udemy.spring.xmlbean;

public class MemoryRepository implements Repository {
    @Override
    public void show() {
        System.out.println("MemoryRepository");
    }
}
