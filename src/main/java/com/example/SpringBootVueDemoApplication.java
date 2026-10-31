package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//项目的总开关
@MapperScan("com.example.mapper")
//这个注解是 MyBatis（或 MyBatis-Plus）专属的，它的作用：告诉 MyBatis：“请你去 com.example.mapper 这个包下面找找看，哪些是 Mapper 接口，赶紧给它们生成代理对象！”
public class SpringBootVueDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootVueDemoApplication.class, args);
    }
}