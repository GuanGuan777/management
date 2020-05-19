package com.syx.management.core.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName FileStorageProperties
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 16:24
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
