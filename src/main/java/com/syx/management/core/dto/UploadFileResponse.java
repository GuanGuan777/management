package com.syx.management.core.dto;

import lombok.Data;

/**
 * @ClassName UploadFileResponse
 * @Description
 * @Author haha
 * @Date 2020/5/18 上午 10:27
 * @Version 1.0
 **/
@Data
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileUri;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String fileDownloadUri,String fileUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileUri = fileUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
