package com.syx.management.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syx.management.core.entity.SysMenuEntity;
import com.syx.management.core.entity.SysRoleEntity;
import com.syx.management.core.entity.SysUserEntity;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @Description 系统用户DAO
 * @Author haha
 * @CreateTime 15:57
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 通过用户ID查询角色集合
     * @Author haha
     * @CreateTime
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
    /**
     * 通过用户ID查询权限集合
     * @Author haha
     * @CreateTime
     * @Param  userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    List<SysMenuEntity> selectSysMenuByUserId(Long userId);

//    Boolean addSysUser(SysUserEntity sysUserEntity);
	
}
