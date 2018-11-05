package com.ak98neon.controller;

import com.ak98neon.dao.DepartmentWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteDepartmentServlet")
@Slf4j
public class DeleteDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            DepartmentWorker.deleteDepartment(Long.parseLong(id));
            response.sendRedirect("/listDepartment");
        } catch (Exception e) {
            log.info("DeleteDepartmentServlet error: {}", e);
        }
    }
}
