package com.syx.management.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syx.management.core.entity.User;
import com.syx.management.core.mapper.UserMapper;
import com.syx.management.core.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/4/6 下午 22:28
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
}
