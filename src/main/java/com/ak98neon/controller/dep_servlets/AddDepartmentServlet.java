package com.ak98neon.controller.dep_servlets;

import com.ak98neon.dao.DepartmentWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddDepartmentServlet", urlPatterns = "/addDepartment")
@Slf4j
/*
  Servlet adding new department in db
 */
public class AddDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            DepartmentWorker.insertDepartment(name);
            resp.sendRedirect("/listDepartment");
        } catch (IOException e) {
            log.info("[POST]add department error: {}", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            getServletContext().getRequestDispatcher("/jsp/addDepartment.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info("[GET]add department error: {}", e);
        }
    }
}