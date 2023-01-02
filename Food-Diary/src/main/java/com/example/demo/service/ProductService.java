package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService{
    List<Product> findProducts(String name);
    void create(Product product);
    void update(Product product);
    void remove(long id);
}
