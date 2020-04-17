package com.syx.management.core.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.syx.management.core.entity.user.Student;

/**
 * @InterfaceName StudentService
 * @Description
 * @Author haha
 * @Date 2020/4/10 上午 01:28
 * @Version 1.0
 **/
@Service
public interface StudentService extends IService<Student> {
    Student findStudentdByUserId(Long userId);
}
