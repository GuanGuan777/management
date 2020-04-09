package com.syx.management.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.syx.management.common.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserAuthAccessDeniedHandler
 * @Description
 * @Author haha
 * @Date 2020/4/8 上午 11:51
 * @Version 1.0
 **/

@Slf4j
@Component
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(403,"未授权"));
    }
}
