package com.example.customerservice.Exception;

import com.example.customerservice.shared.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//aop
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(com.example.customerservice.Exception.CustomerNotFoundException e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorReportingTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e)
    {
        ErrorResponse response=new ErrorResponse();
        response.setErrorMessage(e.getMessage());
        response.setErrorReportingTime(System.currentTimeMillis());
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
