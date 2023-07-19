package com.example.GlobalApi.exception;
//
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
// 
//
//@RestControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
// 
//
//    @ExceptionHandler(BackendException.class)
//    public ResponseEntity<Object> handleBackendException(BackendException ex, WebRequest request) {
//        String errorMessage = "Backend error: " + ex.getMessage();
//        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
//
// 
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
//        String errorMessage = "Internal server error";
//        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
//    }
//}




 

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

 

    @ExceptionHandler(BackendException.class)
    public ResponseEntity<Object> handleBackendException(BackendException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = "Backend error";
        } else {
            errorMessage = "Backend error: " + errorMessage;
        }
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

 

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        String errorMessage = "Internal server error";
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
