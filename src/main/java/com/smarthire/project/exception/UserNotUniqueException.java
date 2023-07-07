package com.smarthire.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    public class UserNotUniqueException extends RuntimeException{
        private String message;
    }
