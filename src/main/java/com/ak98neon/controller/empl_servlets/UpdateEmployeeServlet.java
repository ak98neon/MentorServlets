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

@WebServlet(name = "UpdateEmployeeServlet", urlPatterns = "/updateEmployee")
@Slf4j
public class UpdateEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            long id = Long.parseLong(req.getParameter("id"));
            Employee employee = EmployeeWorker.selectByIdEmployee(id);
            if (employee != null) {
                req.setAttribute("firstName", employee.getFirstName());
                req.setAttribute("lastName", employee.getLastName());
                req.setAttribute("age", employee.getAge());
                req.setAttribute("mail", employee.getMail());
                req.setAttribute("department_id", employee.getDepartmentId());
            }
            req.setAttribute("id", id);
            req.getRequestDispatcher("/jsp/updateEmployee.jsp").forward(req, resp);
        } catch (IOException | NumberFormatException | ServletException e) {
            log.info("Update employee(GET), error {}", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String departmentID = "";
        try {
            req.setCharacterEncoding("UTF-8");
            long id = Long.parseLong(req.getParameter("id"));
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");
            String age = req.getParameter("age");
            int intAge = Integer.parseInt(age);
            String mail = req.getParameter("mail");
            departmentID = req.getParameter("department_id");
            EmployeeWorker.updateEmployee(id, firstName, lastName, intAge, mail);
            resp.sendRedirect("/listEmployee?id=" + departmentID);
        } catch (IOException | NumberFormatException e) {
            log.info("Update employee(GET), error {}", e);
            try {
                resp.sendRedirect("/listEmployee?id=" + departmentID);
            } catch (IOException e1) {
                log.info("[POST] update employee, error: {}", e1);
            }
        }
    }
}