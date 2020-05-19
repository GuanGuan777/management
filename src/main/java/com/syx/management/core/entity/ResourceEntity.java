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

    private Integer type;

    private String uploader;

    private String description;

    private Integer audit;

    private String url;

    private String downloadUrl;

    private Date createTime;

    private Date updateTime;

    private Integer courseId;

    private String fileName;

    private String extractingCode;

    private String fileType;

    private Integer fileSize;

    private String cover;


}
