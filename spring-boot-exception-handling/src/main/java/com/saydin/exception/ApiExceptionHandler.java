package com.saydin.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({NullPointerException.class})
    public String nullPointerException(){
        return "Null pointer exception";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String illegalArgumentException(){
        return "IllegalArgumentException exception";
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound(){
        return "Record is not found";
    }
}
