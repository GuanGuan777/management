package com.syx.management.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.SysUserRoleEntity;
import com.syx.management.core.mapper.SysUserRoleMapper;
import com.syx.management.core.service.SysUserRoleService;

import org.springframework.stereotype.Service;

/**
 * @Description 用户与角色业务实现
 * @Author haha
 * @CreateTime 15:57
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements SysUserRoleService {

}