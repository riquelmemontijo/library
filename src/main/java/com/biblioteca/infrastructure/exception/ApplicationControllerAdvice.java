package com.biblioteca.infrastructure.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(RecordNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(BusinessRulesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBusinessRules(BusinessRulesException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBusinessRules(DataIntegrityViolationException ex){
        return "Data inconsistency";
    }

    @ExceptionHandler(NoAuthorizationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBusinessRules(NoAuthorizationException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.OK)
    public String handleBusinessRules(TokenExpiredException ex){
        return ex.getMessage();
    }
}
