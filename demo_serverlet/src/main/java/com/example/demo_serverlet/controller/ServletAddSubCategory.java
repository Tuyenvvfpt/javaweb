package com.example.demo_serverlet.controller;

import com.example.demo_serverlet.entities.SubCategory;
import com.example.demo_serverlet.services.CategoryService;
import com.example.demo_serverlet.services.SubCategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAddSubCategory", value = "/ServletAddSubCategory")
public class ServletAddSubCategory extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    private SubCategoryService subCategoryService = new SubCategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list_cate",categoryService.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("manage_category.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("sub_category");
        int id_category = Integer.parseInt(request.getParameter("category"));
        SubCategory subCategory = new SubCategory(name,id_category);
        subCategoryService.insert(subCategory);
    }
}
