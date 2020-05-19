package com.syx.management.core.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Iterator;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.syx.management.core.dto.FileStorageProperties;
import com.syx.management.core.exception.FileStorageException;
import com.syx.management.core.service.StorageService;

/**
 * @ClassName StorageServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 16:24
 * @Version 1.0
 **/
@Service
public class StorageServiceImpl implements StorageService {

    private final Path fileStorageLocation;

//    private FileStorageProperties fileStorageProperties;

    @Autowired
    public StorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create directory where the uploaded files will be stored");
        }
    }

//    public StorageServiceImpl() {
//        super();
//    }

    @Override
    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("File name contains invalid path sequence");
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store ResourceEntity " + fileName + ". Please try again later!", ex);
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try{
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()){
                return resource;
            }else{
                throw new FileStorageException("File not found" + fileName);
            }
        }catch (MalformedURLException ex){
            throw new FileStorageException("File not found" + fileName);
        }
    }
}
