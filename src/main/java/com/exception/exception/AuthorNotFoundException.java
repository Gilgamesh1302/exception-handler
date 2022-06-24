package com.exception.exception;

public class AuthorNotFoundException extends Exception{

    public AuthorNotFoundException(String author) {
        super(String.format("author named %s not found", author));
    }

}
