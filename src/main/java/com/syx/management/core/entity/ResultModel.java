package com.syx.management.core.entity;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * @ClassName ResultModel
 * @Description
 * @Author haha
 * @Date 2020/5/4 下午 22:38
 * @Version 1.0
 **/
public class ResultModel {
    private String errorCode;
    private String message;
    private Object remark;
    private Object data;

    public ResultModel(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResultModel() {
    }


    public ResultModel(String errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

//    public ResultModel(ResultCode resultCodeEnum, Object data) {
//        this.errorCode = resultCodeEnum.getCode();
//        this.message = resultCodeEnum.getDesc();
//        this.data = data;
//    }


}
