package com.syx.management.core.entity;

/**
 * @ClassName BaseResponse
 * @Description
 * @Author haha
 * @Date 2020/4/6 下午 22:18
 * @Version 1.0
 **/
public class BaseResponse<T> {
    private int code;
    private T data;
    private String msg;

    public BaseResponse(){}

    public BaseResponse(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
