package com.biblioteca.infrastructure.exception;

public class BusinessRulesException extends RuntimeException{
    public BusinessRulesException(String message){
        super(message);
    }
}
