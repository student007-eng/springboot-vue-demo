package com.example.controller;

import com.example.entity.Admin;
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
    public Long add(@RequestBody Admin admin){
        adminService.save(admin);
        return admin.getId();
    }

    @Operation(summary="管理员信息列表")
    @GetMapping("/admin/list")
    public List<Admin> list(){
        return adminService.list();
    }

    @Operation(summary="修改管理员")
    @PostMapping("/admin/update")
    public Long update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return admin.getId();
    }

    @Operation(summary="删除管理员")
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Long id){
        adminService.removeById(id);
        return "success";
    }
}
