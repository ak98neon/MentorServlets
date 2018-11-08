package com.ak98neon.controller;

import com.ak98neon.dao.DepartmentWorker;
import com.ak98neon.dao.EmployeeWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/index", urlPatterns = "/")
@Slf4j
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            DepartmentWorker.createTable();
            EmployeeWorker.createTable();
            EmployeeWorker.insertEmployee("Artem", "Kudria", 20, "mail@mail.com", 161);
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("index servlet error: {}", e);
            DepartmentWorker.dropTable();
            EmployeeWorker.dropTable();
        }
    }
}