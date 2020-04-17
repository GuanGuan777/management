package com.syx.management.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.syx.management.core.entity.SysMenuEntity;
import com.syx.management.core.service.SysUserService;
import com.syx.management.security.entity.SelfUserEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserPermissionEvaluator
 * @Description
 * @Author haha
 * @Date 2020/4/8 下午 21:23
 * @Version 1.0
 **/


@Slf4j
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {

    @Resource
    private SysUserService sysUserService;



//    * @Param authentication  用户身份
//     * @Param  targetUrl  请求路径
//     * @Param  permission 请求路径权限
//     * @Return boolean 是否通过
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {
        SelfUserEntity selfUserEntity = (SelfUserEntity)authentication.getPrincipal();
        Set<String>permissions = new HashSet<>();
        List<SysMenuEntity>sysMenuEntityList = sysUserService.selectSysMenuByUserId(selfUserEntity.getUserId());
        for (SysMenuEntity sysMenuEntity:sysMenuEntityList){
            permissions.add(sysMenuEntity.getPermission());
        }

        if (permissions.contains(permission.toString())){
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
