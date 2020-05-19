package com.syx.management.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.syx.management.core.dto.UploadFileResponse;
import com.syx.management.core.entity.ResourceEntity;
import com.syx.management.core.service.ResourceService;
import com.syx.management.core.service.StorageService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName StorageController
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 18:16
 * @Version 1.0
 **/

@RestController
@Slf4j
public class StorageController {

    @Autowired
    private final StorageService storageService;

    @Autowired
    private ResourceService resourceService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/uploadFile")
    @PreAuthorize("hasRole('TEACHER')")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file){
        String fileName = storageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName).toUriString();
        return new UploadFileResponse(fileName,fileDownloadUri,file.getContentType(),file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    @PreAuthorize("hasRole('TEACHER')")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.stream(files).map(this::uploadFile).collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Resource resource = storageService.loadFileAsResource(fileName);

        String contentType = null;
        try{
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException ex){
            log.info("Could not determine ResourceEntity type");
        }

        if (contentType == null){
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
