package com.syx.management.core.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.CourseEntity;
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
}
