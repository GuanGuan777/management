package com.syx.management.core.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syx.management.core.entity.SysRoleEntity;
import com.syx.management.core.entity.user.Admin;
import com.syx.management.core.mapper.SysRoleMapper;
import com.syx.management.core.mapper.user.AdminMapper;
import com.syx.management.core.service.AdminService;

/**
 * @ClassName AdminServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/4/10 下午 15:20
 * @Version 1.0
 **/

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Override
    public int insertUser(Admin admin) {
        return this.baseMapper.insert(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return this.baseMapper.updateById(admin);
    }

    @Override
    public int deleteAdmin(Admin admin) {
        return 0;
    }

    @Override
    public Admin findAdminByUserId(Long userId) {
        QueryWrapper<Admin>wrapper = new QueryWrapper<Admin>();
        wrapper.eq("user_id",userId);
        return baseMapper.selectOne(wrapper);
    }


    @Override
    public IPage getAdminPage(Page page, Admin admin) {
        return null;
    }
}
