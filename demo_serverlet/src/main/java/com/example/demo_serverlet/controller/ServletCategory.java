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

@WebServlet(name = "ServletCategory", value = "/ServletCategory")
public class ServletCategory extends HttpServlet {
    private CategoryService categoryService = new CategoryService();
    private SubCategoryService subCategoryService = new SubCategoryService();
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       List<CategoruDTO> categoruDTOList = new ArrayList<>();         //19-10-2023

        List<Product> productList = productService.getAll();

        for (Category category: categoryService.getAll()         //19-10-2023
        ) {
            CategoruDTO  categoruDTO = new CategoruDTO();
            categoruDTO.setId(category.getId());
            categoruDTO.setName(category.getName());
            categoruDTO.setStatus(category.getStatus());
            for (SubCategory subCategory: subCategoryService.getAll()         //19-10-2023
            ) {
                if(category.getId() == subCategory.getId_category()){
                    categoruDTO.getSubCategoryList().add(subCategory);
                }
            }
            categoruDTOList.add(categoruDTO); //must remember
        }

        //19-10-2023
//        request.setAttribute("list_sub", subCategoryService.getAll());         //19-10-2023
        request.setAttribute("lst_category", categoruDTOList); //ver 1 with categoryService

        request.setAttribute("list_product",productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("home_client.jsp");
        requestDispatcher.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
