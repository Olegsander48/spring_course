package com.udemy.spring.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Этот фильтр будет срабатывать для всех URL
 */
@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Фильтр инициализирован");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Запрос получен: " + request.getRemoteAddr());
        chain.doFilter(request, response); // Передаём управление дальше, если не вызвать - запрос дальше не пойдет
        System.out.println("Ответ отправлен");
    }

    @Override
    public void destroy() {
        System.out.println("Фильтр уничтожен");
    }
}
