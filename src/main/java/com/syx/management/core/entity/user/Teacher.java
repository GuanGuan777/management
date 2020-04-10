package com.syx.management.core.entity.user;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @ClassName Teacher
 * @Description
 * @Author haha
 * @Date 2020/4/10 上午 01:13
 * @Version 1.0
 **/

@Data
@TableName("teacher")
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(exist = false)
    private String role = "TEACHER";

    private Long teacherId;

   private String name;

   private int sex;

   private String college;

   private String classes;

   private Date create_time;

   private Date update_time;


    private Long userId;

   private String courses;

}
