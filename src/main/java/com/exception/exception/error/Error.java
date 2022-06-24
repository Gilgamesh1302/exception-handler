package com.exception.exception.error;


import java.time.LocalDate;

public class Error {

    private String errorMessage;
    private LocalDate timestamp;
    private Integer errorCode;
    public Error(String errorMessage, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.timestamp = LocalDate.now();
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
