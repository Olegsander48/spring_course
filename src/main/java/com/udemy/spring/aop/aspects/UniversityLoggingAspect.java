package com.udemy.spring.aop.aspects;

import com.udemy.spring.aop.model.Student;
import com.udemy.spring.aop.model.University;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
}
