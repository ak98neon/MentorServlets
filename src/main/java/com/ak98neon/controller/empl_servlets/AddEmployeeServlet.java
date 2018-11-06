package com.ak98neon.controller.empl_servlets;

import com.ak98neon.dao.EmployeeWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddEmployeeServlet")
@Slf4j
public class AddEmployeeServlet extends HttpServlet {
    private static String depId;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String age = request.getParameter("age");
            int intAge = Integer.parseInt(age);
            String mail = request.getParameter("mail");
            long longDepId = Long.parseLong(depId);
            EmployeeWorker.insertEmployee(firstName, lastName, intAge, mail, longDepId);
            response.sendRedirect("/listEmployee?id=" + depId);
        } catch (NumberFormatException | IOException e) {
            log.info("post insert employee, error: {}", e);
            try {
                response.sendRedirect("/listEmployee?id=" + depId);
            } catch (IOException e1) {
                log.info("post insert employee, error: {}", e1);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            depId = request.getParameter("id");
            getServletContext().getRequestDispatcher("/jsp/addEmployee.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            log.info("add employee, error: {}", e);
        }
    }
}