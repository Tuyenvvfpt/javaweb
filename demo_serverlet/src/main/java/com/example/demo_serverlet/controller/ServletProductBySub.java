package com.example.demo_serverlet.controller;

import com.example.demo_serverlet.dto.CategoruDTO;
import com.example.demo_serverlet.entities.Category;
import com.example.demo_serverlet.entities.Product;
import com.example.demo_serverlet.entities.SubCategory;
import com.example.demo_serverlet.services.CategoryService;
import com.example.demo_serverlet.services.ProductService;
import com.example.demo_serverlet.services.SubCategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletProductBySub", value = "/ServletProductBySub")
public class ServletProductBySub extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    private SubCategoryService subCategoryService = new SubCategoryService();
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));



        List<CategoruDTO> categoruDTOList = new ArrayList<>();
        List<Product> productList = productService.findById(id);

        for (Category category: categoryService.getAll()
        ) {
            CategoruDTO  categoruDTO = new CategoruDTO();
            categoruDTO.setId(category.getId());
            categoruDTO.setName(category.getName());
            categoruDTO.setStatus(category.getStatus());
            for (SubCategory subCategory: subCategoryService.getAll()
            ) {
                if(category.getId() == subCategory.getId_category()){
                    categoruDTO.getSubCategoryList().add(subCategory);
                }
            }
            categoruDTOList.add(categoruDTO);
        }
        request.setAttribute("lst_category", categoruDTOList);
        request.setAttribute("list_product",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home_client.jsp");
        requestDispatcher.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
