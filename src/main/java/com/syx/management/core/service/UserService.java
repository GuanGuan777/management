package com.syx.management.core.service;

import com.syx.management.core.entity.User;

/**
 * @ClassName UserService
 * @Description
 * @Author haha
 * @Date 2020/4/6 下午 17:41
 * @Version 1.0
 **/

public interface UserService {

    public User findByUsername(String username);

//    public User getUser(String username) {
//        // 没有此用户直接返回null
////        if (getUserName(username).containsKey(username))
////            return njull;
//
//        User user = new User();
////        Map<String, String> detail = DataSource.getData().get(username);
//
////        user.setUsername(username);
////        user.setPassword(detail.get("password"));
////        user.setRole(detail.get("role"));
////        user.setPermission(detail.get("permission"));
//        return user;
//    }

}
