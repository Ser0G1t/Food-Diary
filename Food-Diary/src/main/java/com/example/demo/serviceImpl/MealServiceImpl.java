package com.example.demo.serviceImpl;

import com.example.demo.entity.Meal;
import com.example.demo.entity.Product;
import com.example.demo.repository.CoreRepository;
import com.example.demo.service.MealService;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl extends CoreServiceImpl<Meal, Product> implements MealService {

    public MealServiceImpl(CoreRepository<Meal> repository, CoreRepository<Product> secondaryRepository) {
        super(repository, secondaryRepository);
    }

}
