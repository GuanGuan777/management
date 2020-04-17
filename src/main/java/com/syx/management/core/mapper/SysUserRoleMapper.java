package com.syx.management.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syx.management.core.entity.SysUserRoleEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 用户与角色关系DAO
 * @Author haha
 * @CreateTime 15:57
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {
	
}
