package com.syx.management.core.service;

import org.springframework.web.multipart.MultipartFile;

import com.syx.management.core.entity.ResourceEntity;

/**
 * @ClassName ResourceService
 * @Description
 * @Author haha
 * @Date 2020/5/4 下午 22:33
 * @Version 1.0
 **/
public interface ResourceService {
//    String saveUploadFile(MultipartFile file) throws Exception;

    int addResource(ResourceEntity resourceEntity);
}
