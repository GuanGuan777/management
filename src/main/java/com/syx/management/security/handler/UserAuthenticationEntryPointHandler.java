package com.syx.management.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.syx.management.common.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserAuthenticationEntryPointHandler
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 16:19
 * @Version 1.0
 *
 **/

@Slf4j
@Component
public class UserAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(401,"未登录"));
    }
}
