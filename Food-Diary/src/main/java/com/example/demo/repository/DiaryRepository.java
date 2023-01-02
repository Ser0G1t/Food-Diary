package com.example.demo.repository;

import com.example.demo.entity.Day;
import com.example.demo.entity.Diary;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends CoreRepository<Diary> {
}
