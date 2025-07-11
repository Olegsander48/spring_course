package com.udemy.spring.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Произошла ошибка</h2>");
        if (throwable != null) {
            out.println("<p>Исключение: " + throwable.getClass().getName() + "</p>");
            out.println("<p>Сообщение: " + throwable.getMessage() + "</p>");
        } else {
            out.println("<p>Код ошибки: " + statusCode + "</p>");
        }
    }
}
