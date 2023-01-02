package com.example.demo.serviceImpl;

import com.example.demo.entity.Day;
import com.example.demo.entity.Diary;
import com.example.demo.repository.CoreRepository;
import com.example.demo.service.DiaryService;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl extends CoreServiceImpl<Diary, Day> implements DiaryService {

    public DiaryServiceImpl(CoreRepository<Diary> repository, CoreRepository<Day> secondaryRepository) {
        super(repository, secondaryRepository);
    }

}
