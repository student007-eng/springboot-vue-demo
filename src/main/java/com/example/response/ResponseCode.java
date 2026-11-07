package com.example.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(200,"操作成功！"),
    USERNAME_EXIT(1001,"用户名已存在！"),
    ERROR(500,"操作失败！");

    /**响应状态码**/
    private final Integer code;
    /**响应信息**/
    private final String message;
}
