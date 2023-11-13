package com.example.demo_serverlet.controller;

import com.example.demo_serverlet.services.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDeleteStudent", value = "/ServletDeleteStudent")
public class ServletDeleteStudent extends HttpServlet {
    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int flag = studentService.delete(id);
        if (flag==1){
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("Data Success delete");
        }else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("Data Fail delete");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
