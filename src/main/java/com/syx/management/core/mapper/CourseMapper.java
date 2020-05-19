package com.syx.management.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syx.management.core.entity.CourseEntity;
import com.syx.management.core.entity.ResourceEntity;

/**
 * @ClassName CourceMapper
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 22:22
 * @Version 1.0
 **/
@Mapper
public interface CourseMapper extends BaseMapper<CourseEntity> {
}
