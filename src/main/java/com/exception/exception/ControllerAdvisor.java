package com.exception.exception;

import com.exception.exception.error.Error;
import com.exception.exception.error.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(EmptyDocumentListException.class)
    public ResponseEntity<Error> handleEmptyDocumentListException(EmptyDocumentListException exception) {
        Error error = new Error(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DocumentNonExistentException.class)
    public ResponseEntity<Error> handleDocumentNonExistentException(DocumentNonExistentException exception) {
        Error error = new Error(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<Error> handleDocumentNotFoundException(DocumentNotFoundException exception) {
        Error error = new Error(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException exception) {
        ValidationError error = new ValidationError();
        error.createErrorFieldsMap(exception);
        return new ResponseEntity<>(error.getErrorFields(), HttpStatus.BAD_REQUEST);
    }

}

