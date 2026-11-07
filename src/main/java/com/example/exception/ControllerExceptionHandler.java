package com.example.exception;

import com.example.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        return Result.fail(e.getMessage());
    }
    @ExceptionHandler(BussinessException.class)
    public Result handleBussinessException(BussinessException e){
        return Result.fail(e.getCode(),e.getMessage());
    }
}
