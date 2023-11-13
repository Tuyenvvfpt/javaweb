package com.example.demo_serverlet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private int id;
    private String name;
    private String price;
    private File file; //1 product có nhiều ảnh
    private String name_file;
    private int id_category;



}
