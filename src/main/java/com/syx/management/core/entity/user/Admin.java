package com.syx.management.core.entity.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @ClassName Admin
 * @Description
 * @Author haha
 * @Date 2020/4/10 上午 01:14
 * @Version 1.0
 **/
@Data
@TableName("admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long adminId;

    private String name;


    @TableField(exist = false)
    private String role = "ADMIN";

}
