package com.library.infrastructure.exception;

public class NoAuthorizationException extends RuntimeException{
    public NoAuthorizationException(String message){
        super(message);
    }
}
