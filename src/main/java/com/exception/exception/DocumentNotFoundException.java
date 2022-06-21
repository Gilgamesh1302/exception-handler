package com.exception.exception;

public class DocumentNotFoundException extends Exception{

    public DocumentNotFoundException(String keyword) {
        super(String.format("there is no document that contains %s in its title", keyword));
    }

}
