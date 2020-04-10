package com.syx.management.core.entity.user;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @ClassName Student
 * @Description
 * @Author haha
 * @Date 2020/4/10 上午 01:13
 * @Version 1.0
 **/

@Data
@TableName("student")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long studentId;


    private String sno;

    private String name;

    private int sex;

    private String college;

    private String classes;

    private Date create_time;

    private Date update_time;

    private String courses;

    private Long userId;

    @TableField(exist = false)
    private String role = "STUDENT";

}
