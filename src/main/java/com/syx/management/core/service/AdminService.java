package com.syx.management.core.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.syx.management.core.entity.user.Admin;

/**
 * @InterfaceName AdminService
 * @Description
 * @Author haha
 * @Date 2020/4/10 上午 01:26
 * @Version 1.0
 **/
public interface AdminService extends IService<Admin> {
    int insertUser( Admin admin );
    int updateAdmin( Admin admin );
    int deleteAdmin( Admin admin );

    Admin findAdminByUserId(Long user_id);

    IPage getAdminPage(Page page, Admin admin );
}
