package com.udemy.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.udemy.spring.aop")
@EnableAspectJAutoProxy
@PropertySource("classpath:myApp.properties")
public class MyConfig {
}
