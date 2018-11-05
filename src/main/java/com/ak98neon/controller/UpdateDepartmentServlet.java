package com.ak98neon.controller;

import com.ak98neon.dao.DepartmentWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateDepartmentServlet")
public class UpdateDepartmentServlet extends HttpServlet {
    private String id = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = req.getParameter("id");
        req.getRequestDispatcher("/jsp/updateDepartment.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        DepartmentWorker.updateDepartment(Long.parseLong(id), name);
        response.sendRedirect("/listDepartment");
    }
}