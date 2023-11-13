package com.example.demo_serverlet.services;

import com.example.demo_serverlet.entities.Category;
import com.example.demo_serverlet.entities.Product;
import com.example.demo_serverlet.repository.ProductRepository;

import java.util.List;

public class ProductService {
  private   ProductRepository productRepository = new ProductRepository();


  public boolean insert(Product product){
      return productRepository.insert(product);
  }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public List<Product> findById(int id){
        return productRepository.finById(id);
    }
}
