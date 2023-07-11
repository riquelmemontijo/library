package com.biblioteca.infrastructure.exception;

public class TokenExpiredException extends RuntimeException{
    public TokenExpiredException(){
        super("Token is expired. Please, request a new token.");
    }
}
