package com.example.demo.controller;

import com.example.demo.entity.Day;
import com.example.demo.entity.Meal;
import com.example.demo.service.CoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day")
public class DayController extends CoreController<Day,Meal> {

    public DayController(CoreService<Day, Meal> service) {
        super(service);
    }

}
