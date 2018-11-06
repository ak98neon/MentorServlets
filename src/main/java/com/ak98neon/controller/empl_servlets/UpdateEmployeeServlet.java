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

@WebServlet(name = "UpdateEmployeeServlet")
@Slf4j
public class UpdateEmployeeServlet extends HttpServlet {
    private static long id;
    private static String departmentID;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            id = Long.parseLong(req.getParameter("id"));
            Employee employee = EmployeeWorker.selectByIdEmployee(id);
            req.setAttribute("firstName", employee.getFirstName());
            req.setAttribute("lastName", employee.getLastName());
            req.setAttribute("age", employee.getAge());
            req.setAttribute("mail", employee.getMail());
            req.setAttribute("department_id", employee.getDepartmentId());
            req.getRequestDispatcher("/jsp/updateEmployee.jsp").forward(req, resp);
        } catch (IOException | NumberFormatException | ServletException e) {
            log.info("Update employee(GET), error {}", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String firstname = request.getParameter("first_name");
            String lastname = request.getParameter("last_name");
            String age = request.getParameter("age");
            int intAge = Integer.parseInt(age);
            String mail = request.getParameter("mail");
            departmentID = request.getParameter("department_id");
            long longDepId = Long.parseLong(departmentID);
            EmployeeWorker.updateEmployee(id, firstname, lastname, intAge, mail, longDepId);
            response.sendRedirect("/listEmployee?id=" + departmentID);
        } catch (IOException | NumberFormatException e) {
            log.info("Update employee(GET), error {}", e);
            try {
                response.sendRedirect("/listEmployee?id=" + departmentID);
            } catch (IOException e1) {
                log.info("post update employee, error: {}", e1);
            }
        }
    }
}