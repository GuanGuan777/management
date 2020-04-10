package com.syx.management.common.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.syx.management.security.entity.SelfUserEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SecurityUtil
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 22:35
 * @Version 1.0
 **/

@Slf4j
public class SecurityUtil {

    private SecurityUtil(){}

    public static SelfUserEntity getUserInfo(){
        SelfUserEntity userDetails = (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<? extends GrantedAuthority> userA =  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        log.info(userA.toString());
        userDetails.getUserId();

//        log.info((userDetails.getAuthorities().contains("ADMIN")));
//        log.info(userDetails.getAuthorities().contains("STUDENT"));
//        log.info(userDetails.getAuthorities().contains("TEACHER"));
        return userDetails;
    }

    public static Long getUserId(){
        return getUserInfo().getUserId();
    }

    public static String getUserName(){
        return getUserInfo().getUsername();
    }

    public static Collection<GrantedAuthority> getAuthorities(){
        return  getUserInfo().getAuthorities();
    }

//    public static T getInfo(){
////        return getAuthorities();
//        return T;
//    }
}
