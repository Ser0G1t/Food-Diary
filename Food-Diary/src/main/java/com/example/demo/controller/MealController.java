package com.example.demo.controller;

import com.example.demo.entity.Meal;
import com.example.demo.entity.Product;
import com.example.demo.service.CoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal")
public class MealController extends CoreController<Meal, Product> {
    public MealController(CoreService<Meal, Product> service) {
        super(service);
    }
}
