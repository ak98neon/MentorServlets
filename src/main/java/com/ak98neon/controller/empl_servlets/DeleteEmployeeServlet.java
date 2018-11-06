package com.ak98neon.controller.empl_servlets;

import com.ak98neon.dao.EmployeeWorker;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteEmployeeServlet")
@Slf4j
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            final String parametrDepId = "id";
            String id = request.getParameter(parametrDepId);
            EmployeeWorker.deleteEmployee(Long.parseLong(id));
            String depId = request.getParameter("depId");
            response.sendRedirect("/listEmployee?" + parametrDepId + "=" + depId);
        } catch (Exception e) {
            log.info("DeleteEmployeeServlet error: {}", e);
        }
    }
}
