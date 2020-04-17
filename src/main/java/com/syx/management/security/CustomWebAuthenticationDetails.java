package com.syx.management.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * @ClassName CustomWebAuthenticationDetails
 * @Description  //自定义验证，加额外字段
 * @Author haha
 * @Date 2020/4/11 下午 23:08
 * @Version 1.0
 **/
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    private static final long serialVersionUID = 6975601077710753878L;

    private String category;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        category = request.getParameter("category");
    }

    public String getCategory(){
        return category;
    }
}
