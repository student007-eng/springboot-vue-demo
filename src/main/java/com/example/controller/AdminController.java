package com.example.controller;

import com.example.entity.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/add")
    public Long add(@RequestBody Admin admin){
        adminService.save(admin);
        return admin.getId();
    }

    @GetMapping("/admin/list")
    public List<Admin> list(){
        return adminService.list();
    }

    @PostMapping("/admin/update")
    public Long update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return admin.getId();
    }

    @PostMapping("/admin/delete")
    public String delete(@RequestParam Long id){
        adminService.removeById(id);
        return "success";
    }
}
