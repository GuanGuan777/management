package com.syx.management.core.entity.user;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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


    @TableId
    private Long studentId;


    private String sno;

    private String name;

    private int sex;


    private String classes;

    private Timestamp createTime;

    private Timestamp updateTime;

    private String courses;

    private Long userId;

    @TableField(exist = false)
    private String role = "STUDENT";

    private String email;

    private String phone;

    private Date admissionDate;

    private Date graduationDate ;

    private Date birthdate;


}
