package com.example.demo_serverlet.controller;

import com.example.demo_serverlet.entities.Student;
import com.example.demo_serverlet.services.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletEditStudent", value = "/ServletEditStudent")
public class ServletEditStudent extends HttpServlet {
    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = studentService.findById(id);
            request.setAttribute("student",student);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            requestDispatcher.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setId(Integer.parseInt(request.getParameter("user_id")));
        student.setName(request.getParameter("name_user"));
        student.setAddress(request.getParameter("address"));
        student.setAge(Integer.parseInt(request.getParameter("age")));
        studentService.update(student);
        response.sendRedirect("ServletStudent");
    }
}
