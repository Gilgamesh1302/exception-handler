package com.exception.exception.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ValidationError {

    private Map<String, String> errorFields;

    public ValidationError() {
        errorFields = new HashMap<>();
    }

    public void createErrorFieldsMap(MethodArgumentNotValidException exception) {
        exception.getFieldErrors().forEach(error -> {
            errorFields.put(error.getField(), error.getDefaultMessage());
        });
    }



}
