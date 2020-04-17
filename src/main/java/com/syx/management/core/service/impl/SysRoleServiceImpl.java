package com.syx.management.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.SysRoleEntity;
import com.syx.management.core.mapper.SysRoleMapper;
import com.syx.management.core.service.SysRoleService;

import org.springframework.stereotype.Service;

/**
 * @Description 角色业务实现
 * @Author haha
 * @CreateTime 15:57
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

}