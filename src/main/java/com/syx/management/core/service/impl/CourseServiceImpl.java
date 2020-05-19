package com.syx.management.core.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.CourseEntity;
import com.syx.management.core.entity.ResourceEntity;
import com.syx.management.core.mapper.CourseMapper;
import com.syx.management.core.service.CourseService;

/**
 * @ClassName CourceServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 22:33
 * @Version 1.0
 **/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, CourseEntity> implements CourseService {
    @Override
    public CourseEntity selectById(int courseId) {
        QueryWrapper<CourseEntity> wrapper = new QueryWrapper<CourseEntity>();
        wrapper.eq("course_id",courseId);
        return baseMapper.selectById(courseId);
    }
}
