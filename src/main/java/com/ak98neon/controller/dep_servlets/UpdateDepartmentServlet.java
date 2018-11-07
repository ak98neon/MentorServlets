package com.ak98neon.controller.dep_servlets;

import com.ak98neon.dao.DepartmentWorker;
import com.ak98neon.model.Department;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateDepartmentServlet", urlPatterns = "/updateDepartment")
@Slf4j
public class UpdateDepartmentServlet extends HttpServlet {
    /**
     * Buffer variable for id department
     */
    private String id = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            id = req.getParameter("id");
            Department department = DepartmentWorker.selectById(Long.parseLong(id));
            assert department != null;
            req.setAttribute("name", department.getName());
            req.getRequestDispatcher("/jsp/updateDepartment.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("Update Department error: {}", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            DepartmentWorker.updateDepartment(Long.parseLong(id), name);
            response.sendRedirect("/listDepartment");
        } catch (NumberFormatException | IOException e) {
            log.info("Update Department error: {}", e);
        }
    }
}