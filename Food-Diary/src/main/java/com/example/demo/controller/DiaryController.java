package com.example.demo.controller;

import com.example.demo.entity.Day;
import com.example.demo.entity.Diary;
import com.example.demo.serviceImpl.CoreServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diary")
public class DiaryController extends CoreController<Diary,Day> {

    public DiaryController(CoreServiceImpl<Diary, Day> service) {
        super(service);
    }

}
