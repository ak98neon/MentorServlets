package com.ak98neon.controller.dep_servlets;

import com.ak98neon.dao.DepartmentWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteDepartmentServlet", urlPatterns = "/deleteDepartment")
@Slf4j
public class DeleteDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        try {
            DepartmentWorker.deleteDepartment(Long.parseLong(id));
            response.sendRedirect("/listDepartment");
        } catch (Exception e) {
            log.info("[GET]DeleteDepartmentServlet error: {}", e);
        }
    }
}