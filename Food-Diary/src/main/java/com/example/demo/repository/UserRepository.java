package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CoreRepository<User> {
    Optional<User> findByUserName(String userName);
}
