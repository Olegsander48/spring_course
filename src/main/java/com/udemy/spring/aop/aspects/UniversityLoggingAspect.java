package com.udemy.spring.aop.aspects;

import com.udemy.spring.aop.model.Student;
import com.udemy.spring.aop.model.University;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
    private static final Logger LOG = LoggerFactory.getLogger(University.class.getName());

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice() {
        LOG.info("Calling method UniversityLoggingAspect.beforeGetStudentsLoggingAdvice() before");
    }

    @AfterReturning(pointcut = "execution(* getStudents())",
        returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        students.get(0).setName("Mr. Billy Herrington");
        students.get(1).setCourse(5);
        LOG.info("Calling method UniversityLoggingAspect.beforeGetStudentsLoggingAdvice() after returning");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())",
        throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
        LOG.info("Calling method afterThrowingGetStudentsLoggingAdvice() after throwing exception");
        LOG.info("Cause of exception is: " + exception.getMessage());
    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice() {
        LOG.info("Logging in either way method throw exception or not");
    }
}
