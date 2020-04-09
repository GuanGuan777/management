package com.syx.management.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.SysMenuEntity;
import com.syx.management.core.mapper.SysMenuMapper;
import com.syx.management.core.service.SysMenuService;

import org.springframework.stereotype.Service;

/**
 * @Description 权限业务实现
 * @Author haha
 * @CreateTime 15:57
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

}