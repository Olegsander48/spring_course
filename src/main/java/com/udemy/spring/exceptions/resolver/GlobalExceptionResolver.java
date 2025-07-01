package com.udemy.spring.exceptions.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        try {
            if (ex instanceof UserNotFoundException) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, ex.getMessage());
                return new ModelAndView();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
