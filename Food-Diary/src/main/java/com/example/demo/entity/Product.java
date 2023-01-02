package com.example.demo.entity;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "value must be not null")
    @Size(min = 3, message = "value must be longer than 3")
    private String name;
    //    obczaj
    @Digits(message = "value must be not a number", integer = 5, fraction = 0)
    private long kcal;
    @Digits(message = "value must be not a number", integer = 5, fraction = 0)
    private double protein;
    @Digits(message = "value must be not a number", integer = 5, fraction = 0)
    private double carbo;
    @Digits(message = "value must be not a number", integer = 5, fraction = 0)
    private double fat;

    public Product(){}

    public void update(Product product) {
        setName(product.getName());
        setKcal(product.getKcal());
        setProtein(product.getProtein());
        setCarbo(product.getCarbo());
        setFat(product.getFat());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getKcal() {
        return kcal;
    }

    public void setKcal(long kcal) {
        this.kcal = kcal;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbo() {
        return carbo;
    }

    public void setCarbo(double carbo) {
        this.carbo = carbo;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
