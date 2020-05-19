package com.syx.management.core.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @InterfaceName StorageService
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 16:20
 * @Version 1.0
 **/
public interface StorageService {
    String storeFile(MultipartFile file);

    Resource loadFileAsResource(String fileName);
}
