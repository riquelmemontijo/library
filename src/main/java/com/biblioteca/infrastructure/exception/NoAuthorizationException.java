package com.biblioteca.infrastructure.exception;

public class NoAuthorizationException extends RuntimeException{
    public NoAuthorizationException(String message){
        super(message);
    }
}
