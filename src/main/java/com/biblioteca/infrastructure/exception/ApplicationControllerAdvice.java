package com.biblioteca.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(RecordNotFound ex){
        return ex.getMessage();
    }

}
