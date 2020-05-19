package com.syx.management.common.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.syx.management.filter.JWTAuthenticationTokenFilter;
import com.syx.management.security.UserAuthenticationProvider;
import com.syx.management.security.UserPermissionEvaluator;
import com.syx.management.security.handler.UserAuthAccessDeniedHandler;
import com.syx.management.security.handler.UserAuthenticationEntryPointHandler;
import com.syx.management.security.handler.UserLoginFailureHandler;
import com.syx.management.security.handler.UserLoginSuccessHandler;
import com.syx.management.security.handler.UserLogoutSuccessHandler;

/**
 * @ClassName SecurityConfig
 * @Description
 * @Author haha
 * @Date 2020/4/7 下午 21:21
 * @Version 1.0
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启权限注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 自定义登录失败处理器
     */
    @Resource
    private UserLoginFailureHandler userLoginFailureHandler;

    /**
     * 自定义登录成功处理器
     */
    @Resource
    private UserLoginSuccessHandler userLoginSuccessHandler;

    /**
     * 自定义注销成功处理器
     */
    @Resource
    private UserLogoutSuccessHandler userLogoutSuccessHandler;

    /**
     * 自定义暂无权限处理器
     */
    @Resource
    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;

    /**
     * 自定义未登录处理器
     */
    @Resource
    private UserAuthenticationProvider userAuthenticationProvider;

    @Resource
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>authenticationDetailsSource;


    /**
     * 自定义登录逻辑验证器
     */
    @Resource
    private UserAuthenticationEntryPointHandler userAuthenticationEntryPointHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("haha").password("123456").roles("admin");
        auth.authenticationProvider(userAuthenticationProvider);
    }

    @Bean
    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler(){
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(new UserPermissionEvaluator());
        return handler;
    }


    //    加密方式
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder() ;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 不进行权限验证的请求或资源(从配置文件中读取)
                .antMatchers(JWTConfig.antMatchers.split(",")).permitAll()
//                .antMatchers("/admin/**").hasRole("ROLE_ADMIN")
                // 其他的需要登陆后才能访问
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 配置未登录自定义处理类
                .httpBasic().authenticationEntryPoint(userAuthenticationEntryPointHandler)
                .and()
                // 配置登录地址
                .formLogin()
//                .loginProcessingUrl("/user/login")
                .loginPage("/user/login")
                .authenticationDetailsSource(authenticationDetailsSource)
                // 配置登录成功自定义处理类
                .successHandler(userLoginSuccessHandler)
                // 配置登录失败自定义处理类
                .failureHandler(userLoginFailureHandler)
                .and()
                // 配置登出地址
                .logout()
                .logoutUrl("/user/logout")
                // 配置用户登出自定义处理类
                .logoutSuccessHandler(userLogoutSuccessHandler)
                .and()
                // 配置没有权限自定义处理类
                .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
                .and()
                // 开启跨域
                .cors()
                .and()
                // 取消跨站请求伪造防护
                .csrf().disable();
        // 基于Token不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT过滤器
        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
    }
}
