package com.syx.management.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.SysMenuEntity;
import com.syx.management.core.entity.SysRoleEntity;
import com.syx.management.core.entity.SysUserEntity;
import com.syx.management.core.mapper.SysUserMapper;
import com.syx.management.core.service.SysUserService;

import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description 系统用户业务实现
 * @Author haha
 * @CreateTime 15:57
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    /**
     * 根据用户名查询实体
     * @Author haha
     * @CreateTime
     * @Param  username 用户名
     * @Return SysUserEntity 用户实体
     */
    @Override
    public SysUserEntity selectUserByName(String username) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserEntity::getUsername,username);
        return this.baseMapper.selectOne(queryWrapper);
    }
    /**
     * 通过用户ID查询角色集合
     * @Author haha
     * @CreateTime
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    @Override
    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return this.baseMapper.selectSysRoleByUserId(userId);
    }

    /**
     * 根据用户ID查询权限集合
     * @Author haha
     * @CreateTime
     * @Param userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    @Override
    public List<SysMenuEntity> selectSysMenuByUserId(Long userId) {
        return this.baseMapper.selectSysMenuByUserId(userId);
    }

    @Override
    public int addSysUser(SysUserEntity sysUserEntity) {
        return this.baseMapper.insert(sysUserEntity);
    }
}