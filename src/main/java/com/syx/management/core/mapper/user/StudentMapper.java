package com.syx.management.core.mapper.user;

import javax.annotation.ManagedBean;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syx.management.core.entity.user.Admin;
import com.syx.management.core.entity.user.Student;

/**
 * @InterfaceName StudentMapper
 * @Description
 * @Author haha
 * @Date 2020/4/10 下午 17:05
 * @Version 1.0
 **/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
