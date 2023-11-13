package com.example.demo_serverlet.controller;

import com.example.demo_serverlet.entities.Product;
import com.example.demo_serverlet.services.ProductService;
import com.example.demo_serverlet.services.SubCategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.Collection;
import java.util.Date;

@WebServlet(name = "ServletProduct", value = "/ServletProduct")
@MultipartConfig
public class ServletProduct extends HttpServlet {
    private ProductService productService = new ProductService();
    private SubCategoryService subCategoryService = new SubCategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("sub_category",subCategoryService.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("add_product.jsp");
            requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_product");
        String price = request.getParameter("price");
        int id_category =Integer.parseInt(request.getParameter("sub_category"));
        //upload file
        OutputStream out = null;
        InputStream filecontent = null;
        String uploadsDirName = "image";
        String absolutePath = request.getServletContext().getRealPath("");
        String savePath =  absolutePath +File.separator + uploadsDirName;
        File imageSaveDirectory = new File(savePath);
        if (!imageSaveDirectory.exists()) {
            imageSaveDirectory.mkdir();
        }

        try {
        Part filePart = request.getPart("image");
        String fileName = filePart.getSubmittedFileName();
            out = new FileOutputStream(new File(savePath + File.separator
                + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        //end upload file
        Product product = new Product(name,price,fileName,id_category);
        boolean result =  productService.insert(product);
        if (result){
            response.sendRedirect("ServletProduct");
        }else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
