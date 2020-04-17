package com.syx.management.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.syx.management.common.utils.ResultUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserLogoutSuccessHandler
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 16:47
 * @Version 1.0
 **/

@Slf4j
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Map<String,Object>resultData = new HashMap<>();
        resultData.put("code","200");
        resultData.put("msg","登出成功");
        SecurityContextHolder.clearContext();
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultSuccess(resultData));
    }
}
