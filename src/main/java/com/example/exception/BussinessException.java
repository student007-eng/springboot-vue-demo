package com.example.exception;

import com.example.response.ResponseCode;
import lombok.Data;

@Data
public class BussinessException extends RuntimeException{
    private Integer code;//错误码
    private String message;//异常信息

    public BussinessException(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
    public BussinessException(String message){
        this.message=message;
    }
    public BussinessException(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
