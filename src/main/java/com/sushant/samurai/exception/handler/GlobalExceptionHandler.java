package com.sushant.samurai.exception.handler;

import com.sushant.samurai.core.dto.ApiResponse;
import com.sushant.samurai.exception.DuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ApiResponse> handleDuplicateException(DuplicateException e) {
        ApiResponse apiResponse = new ApiResponse(false, e.getMessage(), HttpStatus.CONFLICT.value(), LocalDateTime.now());
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }



}
