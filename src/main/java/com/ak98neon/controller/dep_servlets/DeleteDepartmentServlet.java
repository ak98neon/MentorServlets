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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            DepartmentWorker.deleteDepartment(Long.parseLong(id));
            resp.sendRedirect("/listDepartment");
        } catch (Exception e) {
            log.info("[GET]DeleteDepartmentServlet error: {}", e);
        }
    }
}