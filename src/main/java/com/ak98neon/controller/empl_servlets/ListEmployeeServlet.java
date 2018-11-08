package com.ak98neon.controller.empl_servlets;

import com.ak98neon.dao.EmployeeWorker;
import com.ak98neon.model.Employee;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListEmployeeServlet", urlPatterns = "/listEmployee")
@Slf4j
public class ListEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        processListEmployee(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        processListEmployee(req, resp);
    }

    private void processListEmployee(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String depId = req.getParameter("id");
            List<Employee> employees = EmployeeWorker.selectAllEmployeesByDepartment(Long.parseLong(depId));
            req.setAttribute("employees", employees);
            req.setAttribute("depId", depId);
            req.getRequestDispatcher("/jsp/listEmployee.jsp").forward(req, resp);
        } catch (IOException | NumberFormatException | ServletException e) {
            log.info("parse dep id, error: {}", e);
        }
    }
}