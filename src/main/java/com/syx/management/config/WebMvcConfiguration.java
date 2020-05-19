package com.syx.management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebMvcConfiguration
 * @Description
 * @Author haha
 * @Date 2020/5/19 下午 17:30
 * @Version 1.0
 **/
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("file:E://uploads/");
//        super.addResourceHandlers(registry);
//    }
}
