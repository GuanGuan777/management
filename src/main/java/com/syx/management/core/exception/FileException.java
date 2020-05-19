package com.syx.management.core.exception;

/**
 * @ClassName FileException
 * @Description
 * @Author haha
 * @Date 2020/5/18 上午 10:29
 * @Version 1.0
 **/
public class FileException extends RuntimeException{
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
