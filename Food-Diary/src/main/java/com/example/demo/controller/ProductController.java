package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.serviceImpl.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductServiceImpl service;

    public ProductController(ProductServiceImpl service){
        this.service=service;
    }
    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        service.create(product);
        return ResponseEntity.ok().build();
    }
    @PutMapping("update")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        service.update(product);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Product> remove(@PathVariable long id) {
        service.remove(id);
        return ResponseEntity.ok().build();
    }
}
