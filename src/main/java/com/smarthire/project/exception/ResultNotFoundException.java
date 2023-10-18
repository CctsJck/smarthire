package com.smarthire.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultNotFoundException extends IndexOutOfBoundsException{
    private String message;
}
