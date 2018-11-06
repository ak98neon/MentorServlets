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

@WebServlet(name = "ListEmployeeServlet")
@Slf4j
public class ListEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        processListEmployee(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processListEmployee(request, response);
    }

    private void processListEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            String depId = request.getParameter("id");
            List<Employee> employees = EmployeeWorker.selectAllEmployeesByDepartment(Long.parseLong(depId));
            request.setAttribute("employees", employees);
            request.setAttribute("depId", depId);
            request.getRequestDispatcher("/jsp/listEmployee.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            log.info("parse dep id, error: {}", e);
        }
    }
}