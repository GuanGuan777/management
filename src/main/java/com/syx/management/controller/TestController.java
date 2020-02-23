package com.syx.management.controller;

import java.util.Map;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syx.management.mapper.StudentMapper;

/**
 * @ClassName TestController
 * @Description
 * @Author calia
 * @Date 2020/2/23 18:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private StudentMapper studentMapper;
    @RequestMapping("/ss")

    public Map find(){
        return studentMapper.findById(1);
    }
}
