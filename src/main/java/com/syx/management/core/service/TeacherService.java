package com.syx.management.core.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syx.management.core.entity.user.Teacher;

/**
 * @InterfaceName TeacherService
 * @Description
 * @Author haha
 * @Date 2020/4/10 上午 01:28
 * @Version 1.0
 **/
@Service
public interface TeacherService extends IService<Teacher> {
    Teacher findTeacherByUserId(Long userId);
}
