package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Admin;
import com.example.exception.BussinessException;
import com.example.response.ResponseCode;
import com.example.response.Result;
import com.example.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "管理员信息管理")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;//声明并注入依赖

    @Operation(summary="新增管理员")
    @PostMapping("/admin/add")
    public Result add(@RequestBody Admin admin){
        LambdaQueryWrapper<Admin> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Admin::getUsername,admin.getUsername());
        long count=adminService.count(lambdaQueryWrapper);
        if(count>0){
            throw new BussinessException(ResponseCode.USERNAME_EXIT);
        }
        adminService.save(admin);
        return Result.success();
    }

    @Operation(summary="管理员信息列表")
    @PostMapping("/admin/list")
    public Result<Page<Admin>> list(
            @RequestBody Admin admin,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "2") Integer pageSize){
        //模糊查询
        LambdaQueryWrapper<Admin> lambdaQueryWrapper=new LambdaQueryWrapper();
        lambdaQueryWrapper.like(admin.getName()!=null,Admin::getName,admin.getName());
        lambdaQueryWrapper.like(admin.getTel()!=null,Admin::getTel,admin.getTel());
        lambdaQueryWrapper.like(admin.getUsername()!=null,Admin::getUsername,admin.getUsername());
        //使用Mybatis-Plus自带的分页
        Page<Admin> page=new Page<>(pageNum,pageSize);
        //执行查询，把条件和分页对象一起传进去
        Page<Admin> resultPage=adminService.page(page,lambdaQueryWrapper);
        return Result.data(resultPage);
    }

    @Operation(summary="修改管理员")
    @PostMapping("/admin/update")
    public Result update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return Result.success();
    }

    @Operation(summary="删除管理员")
    @PostMapping("/admin/delete")
    public Result delete(@RequestParam Long id){
        adminService.removeById(id);
        return Result.success();
    }
}
