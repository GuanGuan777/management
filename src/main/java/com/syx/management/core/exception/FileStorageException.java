package com.syx.management.core.exception;

/**
 * @ClassName FileStorageException
 * @Description
 * @Author haha
 * @Date 2020/5/18 下午 16:23
 * @Version 1.0
 **/

public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
