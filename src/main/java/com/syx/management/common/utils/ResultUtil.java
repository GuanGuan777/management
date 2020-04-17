package com.syx.management.common.utils;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ResultUtil
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 12:02
 * @Version 1.0
 **/

@Slf4j
public class ResultUtil {
    private ResultUtil(){}

    public static void responseJson(ServletResponse response, Map<String,Object>resultMap){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(resultMap));
        }catch (Exception e){
            log.error("【JSON输出异常】");
        }
    }

    public static Map<String,Object> resultSuccess(Map<String,Object>resultMap){
        resultMap.put("message","操作成功");
        resultMap.put("code",200);
        return resultMap;
    }


    public static Map<String,Object> resultError(Map<String,Object>resultMap){
        resultMap.put("message","操作失败");
        resultMap.put("code",500);
        return resultMap;
    }


    public static Map<String,Object> resultCode(Integer code,String msg){
        Map<String,Object>resultMap = new HashMap<>();
        resultMap.put("message",msg);
        resultMap.put("code",code);
        return resultMap;
    }





}
