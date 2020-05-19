package com.syx.management.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.ResourceEntity;
import com.syx.management.core.mapper.ResourceMapper;
import com.syx.management.core.service.ResourceService;

/**
 * @ClassName ResourceServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/4 下午 22:34
 * @Version 1.0
 **/

@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourceEntity> implements ResourceService {

    @Value("${web.upload-path}")
    private String uploadStaticLocal;

//    @Override
//    public String saveUploadFile(MultipartFile file) throws Exception{
//        String fileName = file.getOriginalFilename();
//        String localPath = uploadStaticLocal + fileName;
//        file.transferTo(new File(localPath));
//        return fileName;
//    }

    @Override
    public int addResource(ResourceEntity resourceEntity) {
        return baseMapper.insert(resourceEntity);
    }

    @Override
    public List<ResourceEntity> getResource(int courseId) {
        QueryWrapper<ResourceEntity> wrapper = new QueryWrapper<ResourceEntity>();
        wrapper.eq("course_id",courseId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public int deleteResource(Integer resourceId) {
        return baseMapper.deleteById(resourceId);
    }
}
