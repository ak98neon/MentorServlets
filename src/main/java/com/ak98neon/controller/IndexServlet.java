package com.ak98neon.controller;

import com.ak98neon.dao.DepartmentWorker;
import com.ak98neon.dao.EmployeeWorker;
import com.ak98neon.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/index")
@Slf4j
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentWorker.createTable();
        EmployeeWorker.createTable();
        EmployeeWorker.insertEmployee("Artem", "Kudria", 20, "mail@mail.com", 161);
        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}