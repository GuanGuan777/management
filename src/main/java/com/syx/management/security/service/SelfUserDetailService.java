package com.syx.management.security.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.syx.management.core.entity.SysUserEntity;
import com.syx.management.core.service.SysUserService;
import com.syx.management.security.entity.SelfUserEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SelfUserDetailService
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 17:10
 * @Version 1.0
 **/
@Slf4j
@Service
public class SelfUserDetailService implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public SelfUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity sysUserEntity = sysUserService.selectUserByName(username);
        if(sysUserEntity!=null){
            SelfUserEntity selfUserEntity = new SelfUserEntity();
            BeanUtils.copyProperties(sysUserEntity,selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}
