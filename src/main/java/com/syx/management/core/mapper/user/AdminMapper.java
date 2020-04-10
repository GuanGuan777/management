package com.syx.management.core.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syx.management.core.entity.user.Admin;

/**
 * @InterfaceName AdminMapper
 * @Description
 * @Author haha
 * @Date 2020/4/10 下午 17:04
 * @Version 1.0
 **/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
