package com.exception.exception;

public class DocumentNonExistentException extends Exception{

    public DocumentNonExistentException(Long id) {
        super(String.format("Document with id %s not found", id));
    }

}
