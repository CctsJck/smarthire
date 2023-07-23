package com.smarthire.project.handler;

import com.smarthire.project.exception.*;
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

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SearchNotFoundException.class)
    public  ResponseEntity<String> handleSearchNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptySearchesException.class)
    public ResponseEntity<String> handleEmptySearchesException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailNotSendException.class)
    public ResponseEntity<String> handleEmailNotSendException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(EmailNotCheckedException.class)
    public ResponseEntity<String> handleEmailNotCheckedException(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
    }


}
