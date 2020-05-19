package com.syx.management.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.syx.management.core.entity.SysRoleEntity;
import com.syx.management.core.service.SysUserService;
import com.syx.management.security.entity.SelfUserEntity;
import com.syx.management.security.service.SelfUserDetailService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserAuthenticationProvider
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 16:49
 * @Version 1.0
 **/


@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private SelfUserDetailService selfUserDetailService;

    @Resource
    private SysUserService sysUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
        SelfUserEntity userInfo = selfUserDetailService.loadUserByUsername(userName);
        if(userInfo == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if(!new BCryptPasswordEncoder().matches(password,userInfo.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        if("PROHIBIT".equals(userInfo.getStatus())){
            throw new LockedException("该用户已被冻结");
        }
        Set<GrantedAuthority>authorities = new HashSet<>();
        List<SysRoleEntity>sysRoleEntityList = sysUserService.selectSysRoleByUserId(userInfo.getUserId());
        boolean noPermission = false;
        for(SysRoleEntity sysRoleEntity:sysRoleEntityList){
            log.info(sysRoleEntity.getRoleName());
            log.info(details.getCategory());
            log.info("[{}]",!sysRoleEntity.getRoleName().equals(details.getCategory()));
            authorities.add(new SimpleGrantedAuthority("ROLE_"+sysRoleEntity.getRoleName()));
        }
        if(!authorities.contains(new SimpleGrantedAuthority("ROLE_"+details.getCategory()))){
            throw new InsufficientAuthenticationException("没有权限，请检查角色是否选择正确");
        }

//        if(sysRoleEntity.getRoleName().equals(details.getCategory())){
//        }
        userInfo.setAuthorities(authorities);

        return new UsernamePasswordAuthenticationToken(userInfo,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
