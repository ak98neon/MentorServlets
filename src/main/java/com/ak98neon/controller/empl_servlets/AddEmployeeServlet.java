package com.ak98neon.controller.empl_servlets;

import com.ak98neon.dao.EmployeeWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddEmployeeServlet", urlPatterns = "/addEmployee")
@Slf4j
public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String depId = req.getParameter("depId");
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");
            String age = req.getParameter("age");
            int intAge = Integer.parseInt(age);
            String mail = req.getParameter("mail");
            long longDepId = Long.parseLong(depId);
            EmployeeWorker.insertEmployee(firstName, lastName, intAge, mail, longDepId);
            resp.sendRedirect("/listEmployee?id=" + depId);
        } catch (NumberFormatException | IOException e) {
            log.info("post insert employee, error: {}", e);
            try {
                resp.sendRedirect("/listEmployee?id=" + req.getParameter("depId"));
            } catch (IOException e1) {
                log.info("post insert employee, error: {}", e1);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String depId = req.getParameter("id");
            req.setAttribute("id", depId);
            getServletContext().getRequestDispatcher("/jsp/addEmployee.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("add employee, error: {}", e);
        }
    }
}