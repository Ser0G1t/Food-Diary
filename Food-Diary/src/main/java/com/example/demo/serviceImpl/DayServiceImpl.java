package com.example.demo.serviceImpl;

import com.example.demo.entity.Day;
import com.example.demo.entity.Meal;
import com.example.demo.repository.CoreRepository;
import com.example.demo.service.DayService;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImpl extends CoreServiceImpl<Day, Meal> implements DayService{

    public DayServiceImpl(CoreRepository<Day> repository, CoreRepository<Meal> secondaryRepository) {
        super(repository, secondaryRepository);
    }

}
