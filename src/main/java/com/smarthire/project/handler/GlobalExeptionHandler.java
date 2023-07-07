package com.smarthire.project.handler;

import com.smarthire.project.exception.UserNotUniqueException;
import com.smarthire.project.model.dto.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExeptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleDefaultException(MethodArgumentNotValidException e){
        ExceptionResponse ex = ExceptionResponse.builder()
                .message(e.getFieldError().getDefaultMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException e){
        ExceptionResponse ex = ExceptionResponse.builder()
                .message(e.getFieldError().getDefaultMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotUniqueException.class)
    public ResponseEntity<ExceptionResponse> usernameAlreadyExistHandler(UserNotUniqueException ex){
        return new ResponseEntity<>(ExceptionResponse.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.OK);
    }


}
