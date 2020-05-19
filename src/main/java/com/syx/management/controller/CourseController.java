package com.syx.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syx.management.common.utils.ResultUtil;
import com.syx.management.core.entity.CourseEntity;
import com.syx.management.core.entity.ResourceEntity;
import com.syx.management.core.service.CourseService;
import com.syx.management.core.service.ResourceService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName CourseController
 * @Description
 * @Author haha
 * @Date 2020/5/19 下午 15:06
 * @Version 1.0
 **/

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    CourseService courseService;

    @Resource
    ResourceService resourceService;

    @GetMapping("/{courseId}/resources")
//    @PreAuthorize("hasRole('TEACHER')")
    public Map<String, Object> getCourseResource(@PathVariable int courseId){
        List<ResourceEntity> result = resourceService.getResource(courseId);
        Map<String,Object>resultMap = new HashMap<>();
        resultMap.put("data",result);
        return ResultUtil.resultSuccess(resultMap);
    }

    @GetMapping("/{courseId}")
    public Map<String, Object> getCourse(@PathVariable int courseId){
//        CourseEntity result = courseService.selectById(courseId);
        CourseEntity result = courseService.getById(courseId);
        Map<String,Object>resultMap = new HashMap<>();
        resultMap.put("data",result);
        return ResultUtil.resultSuccess(resultMap);
    }


    @GetMapping("")
    public Map<String, Object> getCourseList(){
        List<CourseEntity> result = courseService.list();
        Map<String,Object>resultMap = new HashMap<>();
        resultMap.put("data",result);
        return ResultUtil.resultSuccess(resultMap);
    }

}
