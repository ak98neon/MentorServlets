package com.ak98neon.controller;

import com.ak98neon.dao.DepartmentWorker;
import com.ak98neon.model.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "ListDepartmentServlet", urlPatterns = "/listDepartment")
public class ListDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentWorker.createTable();
        DepartmentWorker.insertDepartment("TESTDEP");
        List<Department> departmentList = DepartmentWorker.selectAllDepartments();
        request.setAttribute("departments", departmentList);

        getServletContext().getRequestDispatcher("/jsp/listDepartment").forward(request, response);
    }
}