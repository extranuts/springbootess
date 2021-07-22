package com.example.springbootess.handler;

import com.example.springbootess.exception.ResourceNotFoundDetails;
import com.example.springbootess.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDetails>
    handleResourceNotFoundException(ResourceNotFoundException rnfe){

        return new ResponseEntity<>(
                ResourceNotFoundDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rnfe.getMessage())
                .developerMessage(rnfe.getClass().getName())
                .build(),
                HttpStatus.NOT_FOUND);
    }
}