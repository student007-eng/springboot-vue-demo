package com.example.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.entity.Admin;
import com.example.mapper.AdminMapper;
import com.example.service.AdminService;
import org.springframework.stereotype.Service;

@Service
/**增加这个注解，这个类就托管给spring了，在controller里面就可以引用这个类了**/
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
}
