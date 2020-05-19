package com.syx.management.core.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @ClassName CourseEntity
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 22:16
 * @Version 1.0
 **/
@Data
@TableName("course")
public class CourseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer courseId;

    private String title;

    private String desc;

    private Integer credit;

    private Integer hours;

    private Date createTime;

    private Date updateTime;

}
