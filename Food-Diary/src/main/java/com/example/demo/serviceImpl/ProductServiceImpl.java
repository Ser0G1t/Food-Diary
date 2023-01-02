package com.example.demo.serviceImpl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Product> findProducts(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public void create(Product product) {
        repository.save(product);
    }

    @Override
    public void update(Product product) {
        Product toUpdate=repository.findById(product.getId())
                .orElseThrow(()->new NullPointerException("no value with this id"));
        repository.save(toUpdate);
    }

    @Override
    public void remove(long id) {
        Product toDelete=repository.findById(id)
                .orElseThrow(()->new NullPointerException("no value with this id"));
        repository.delete(toDelete);
    }


}
