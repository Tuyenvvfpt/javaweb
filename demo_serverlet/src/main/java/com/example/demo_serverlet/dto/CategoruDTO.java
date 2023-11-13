package com.example.demo_serverlet.dto;

import com.example.demo_serverlet.entities.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class CategoruDTO {
    private int id;
    private String name;
    private int status;
    private List<SubCategory> subCategoryList = new ArrayList<>();

    public CategoruDTO() {
    }

    public CategoruDTO(int id, String name, int status, List<SubCategory> subCategoryList) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.subCategoryList = subCategoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
