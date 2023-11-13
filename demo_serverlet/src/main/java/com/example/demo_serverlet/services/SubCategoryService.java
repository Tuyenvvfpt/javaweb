package com.example.demo_serverlet.services;

import com.example.demo_serverlet.entities.SubCategory;
import com.example.demo_serverlet.repository.SubCategoryRepository;

import java.util.List;

public class SubCategoryService {
    private SubCategoryRepository categoryRepository = new SubCategoryRepository();

    public List<SubCategory> getAll(){
        return categoryRepository.getAll();
    }
    public boolean insert(SubCategory subCategory){
        return categoryRepository.insert(subCategory);
    }
}
