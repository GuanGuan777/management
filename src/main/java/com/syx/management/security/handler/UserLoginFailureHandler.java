package com.syx.management.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.syx.management.common.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserLoginFailureHandler
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 16:21
 * @Version 1.0
 **/

@Slf4j
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if(e instanceof UsernameNotFoundException){
            log.info("登陆失败"+e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户名不存在"));
        }
        if(e instanceof LockedException){
            log.info("登陆失败"+e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户名被冻结"));
        }
        if(e instanceof BadCredentialsException){
            log.info("登陆失败"+e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户名密码不正确"));
        }
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"登录失败"));
    }
}
