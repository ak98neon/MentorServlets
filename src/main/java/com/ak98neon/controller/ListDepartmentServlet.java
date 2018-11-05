package com.ak98neon.controller;

import com.ak98neon.dao.DepartmentWorker;
import com.ak98neon.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "ListDepartmentServlet")
@Slf4j
public class ListDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        DepartmentWorker.createTable();
        DepartmentWorker.insertDepartment("TESTDEP");
        List<Department> departmentList = DepartmentWorker.selectAllDepartments();
        request.setAttribute("departments", departmentList);

        try {
            request.getRequestDispatcher("/jsp/listDepartment.jsp").forward(request, response);
        } catch (Exception e) {
            log.info("Error forward: {} ", e.getMessage());
        }
    }
}