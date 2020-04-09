package com.syx.management.common.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.syx.management.security.entity.SelfUserEntity;

import net.sf.jsqlparser.statement.select.SelectExpressionItem;

/**
 * @ClassName SecurityUtil
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 22:35
 * @Version 1.0
 **/
public class SecurityUtil {
    private SecurityUtil(){}

    public static SelfUserEntity getUserInfo(){
        SelfUserEntity userDetails = (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }

    public static Long getUserId(){
        return getUserInfo().getUserId();
    }

    public static String getUserName(){
        return getUserInfo().getUsername();
    }
}
