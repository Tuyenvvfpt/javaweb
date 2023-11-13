package com.example.demo_serverlet.services;

import com.example.demo_serverlet.entities.Category;
import com.example.demo_serverlet.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private CategoryRepository categoryRepository = new CategoryRepository();
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public boolean insert(Category category){
        return categoryRepository.insert(category);
    }
}
