package com.syx.management.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.syx.management.common.config.JWTConfig;
import com.syx.management.common.utils.ResultUtil;
import com.syx.management.filter.JwtFilter;
import com.syx.management.security.entity.SelfUserEntity;
import com.syx.management.security.jwt.JwtUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserLoginSuccessHandler
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 16:29
 * @Version 1.0
 **/


@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SelfUserEntity selfUserEntity = (SelfUserEntity)authentication.getPrincipal();
        String token = JwtUtils.createAccessToken(selfUserEntity);
        token = JWTConfig.tokenPrefix + token;
        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code","200");
        resultData.put("msg","登录成功");
//        resultData.put("role",selfUserEntity.getAuthorities());
        resultData.put("token",token);
        ResultUtil.responseJson(httpServletResponse,resultData);
    }
}
