package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="meals")
public class Meal extends CoreEntity<Meal,Product>{
    @NotNull(message = "value must be not null")
    @Size(min = 3, message = "value must be longer than 3")
    private String title;

    public Meal(){}

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @Override
    public void update(Meal meal) {
        setTitle(meal.getTitle());
        setProducts(meal.getProducts());
    }

    @Override
    public List<Product> getCollection() {
        return getProducts();
    }

    @Override
    public void addToCollection(Product product) {
        getProducts().add(product);
    }
    @Override
    public void removeFromCollection(Product product) {
        getProducts().remove(product);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
