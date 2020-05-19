package com.syx.management.core.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @ClassName ResourceEntity
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 22:09
 * @Version 1.0
 **/
@Data
@TableName("resources")
public class ResourceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer resourceId;

    private String title;

    private String type;

    private String uploader;

    private Integer check;

    private String url;

    private Date createTime;

    private Date updateTime;

    private Integer courseId;

    private String fileName;

    private String code;

    private String fileType;

    private Integer fileSize;

}
