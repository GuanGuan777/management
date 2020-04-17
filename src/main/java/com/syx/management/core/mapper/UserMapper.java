package com.syx.management.core.mapper;

import com.syx.management.core.entity.User;

/**
 * @InterfaceName UserMapper
 * @Description
 * @Author calia
 * @Date 2020/2/23 17:53
 * @Version 1.0
 **/
public interface UserMapper {
    public User findByUsername(String username);
}

