package com.syx.management.core.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syx.management.core.entity.user.Teacher;

/**
 * @InterfaceName TeacherMapper
 * @Description
 * @Author haha
 * @Date 2020/4/10 下午 17:06
 * @Version 1.0
 **/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
}
