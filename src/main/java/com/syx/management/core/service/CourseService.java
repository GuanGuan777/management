package com.syx.management.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.syx.management.core.entity.CourseEntity;

/**
 * @InterfaceName CourceService
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 22:33
 * @Version 1.0
 **/
public interface CourseService extends IService<CourseEntity> {

    CourseEntity selectById(int courseId);
}
