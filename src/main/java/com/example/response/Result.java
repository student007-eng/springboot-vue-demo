package com.example.response;

import lombok.Data;

@Data//必须要加
/**统一的返回结果对象**/
public class Result<T> {
    private Integer code;
    private String message;
    private T data;
    private Result(Integer code){
        this.code=code;
    }
    private Result(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    private Result(Integer code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
    public static <T> Result<T> success(){
        return new Result<>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> Result<T> success(String message){
        return new Result<>(ResponseCode.SUCCESS.getCode(),message);
    }
    public static <T> Result<T> data(T data){
        return new Result<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),data);
    }
    public static <T> Result<T> fail(){
        return new Result<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
    }
    public static <T> Result<T> fail(String message){
        return new Result<>(ResponseCode.ERROR.getCode(),message);
    }
    public static <T> Result<T> fail(ResponseCode responseCode){
        return new Result<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
    }
    public static <T> Result<T> fail(Integer code,String message){
        return new Result<>(code,message);
    }
}
