package com.example.customerservice.Exception;

public class CustomerNotFoundException extends RuntimeException {
    private String message;

    public CustomerNotFoundException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}