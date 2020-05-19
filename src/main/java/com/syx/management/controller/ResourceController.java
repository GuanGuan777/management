package com.syx.management.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.syx.management.common.utils.ResultUtil;
import com.syx.management.core.entity.ResourceEntity;
import com.syx.management.core.service.ResourceService;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ResourceController
 * @Description
 * @Author haha
 * @Date 2020/5/4 下午 22:31
 * @Version 1.0
 **/

@Slf4j
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Value("${web.upload-path}")
    private String uploadStaticUrl;

    @Resource
    ResourceService resourceService;

    @PostMapping("")
    @PreAuthorize("hasRole('TEACHER')")
    public Map<String, Object> upload(@RequestBody ResourceEntity resourceEntity){
        int result = resourceService.addResource(resourceEntity);
        Map<String,Object>resultMap = new HashMap<>();
        resultMap.put("data",result);
        return ResultUtil.resultSuccess(resultMap);
    }

    @DeleteMapping("/{resourceId}")
    public Map<String, Object> upload(@PathVariable Integer resourceId){
        int result = resourceService.deleteResource(resourceId);
        Map<String,Object>resultMap = new HashMap<>();
        resultMap.put("data",result);
        return ResultUtil.resultSuccess(resultMap);
    }



//    public Map<String, Object> upload(@RequestParam("files") MultipartFile file) {
//        try {
//            if (file.isEmpty()) {
//                return ResultUtil.resultCode(500, "文件不能为空");
//            }
//            String fileName = resourceService.saveUploadFile(file);
//            return ResultUtil.resultCode(200, uploadStaticUrl +'/' + fileName);
//        } catch (Exception e) {
//            log.error(e.toString());
//            return ResultUtil.resultCode(500, e.toString());
//        }
//    }
}
