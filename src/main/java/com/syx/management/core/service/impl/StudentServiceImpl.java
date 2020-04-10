package com.syx.management.core.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.user.Admin;
import com.syx.management.core.entity.user.Student;
import com.syx.management.core.mapper.user.StudentMapper;
import com.syx.management.core.service.StudentService;

/**
 * @ClassName StudentServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/4/10 下午 15:21
 * @Version 1.0
 **/

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Override
    public Student findStudentdByUserId(Long userId) {
        QueryWrapper<Student>wrapper = new QueryWrapper<Student>();
        wrapper.eq("user_id",userId);
        return baseMapper.selectOne(wrapper);
    }
}
