package com.udemy.spring.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException(ArithmeticException ex) {
        return new ResponseEntity<>("Ошибка: деление на ноль!", HttpStatus.BAD_REQUEST);
    }
}
