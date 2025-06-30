package com.udemy.spring.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car implements FactoryBean<String> {
    private String model;

    public Car(@Value("BMW m5 competition") String model) {
        this.model = model;
    }

    @Override
    public String getObject() throws Exception {
        return model;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
