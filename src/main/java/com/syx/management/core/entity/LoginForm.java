package com.syx.management.core.entity;

import lombok.Data;

/**
 * @ClassName LoginForm
 * @Description
 * @Author haha
 * @Date 2020/4/7 上午 01:38
 * @Version 1.0
 **/
@Data
public class LoginForm {

    private String username;
    private String password;
    private Integer role;

}
