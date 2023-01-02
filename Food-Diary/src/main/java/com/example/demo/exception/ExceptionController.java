package com.example.demo.exception;

import com.example.demo.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> notNullException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO("value doesn't exist"));
    }
}
