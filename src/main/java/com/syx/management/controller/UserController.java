package com.syx.management.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.syx.management.common.utils.ResultUtil;
import com.syx.management.common.utils.SecurityUtil;
import com.syx.management.core.entity.BaseResponse;
import com.syx.management.core.entity.LoginForm;
import com.syx.management.core.entity.SysUserEntity;
import com.syx.management.core.entity.SysUserRoleEntity;
import com.syx.management.core.service.SysMenuService;
import com.syx.management.core.service.SysRoleService;
import com.syx.management.core.service.SysUserRoleService;
import com.syx.management.core.service.SysUserService;
import com.syx.management.core.service.UserService;
import com.syx.management.security.entity.SelfUserEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserController
 * @Description
 * @Author haha
 * @Date 2020/4/6 下午 17:40
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysRoleService sysRoleService;


    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SysMenuService sysMenuService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserController() {
    }


    @PostMapping("/login")
    public BaseResponse login(@RequestBody LoginForm loginForm){
        return new BaseResponse();
    }

    // ADMIN 1 STUDENT 2 TEACHER 3
    @PostMapping("/")
    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> AddUser(@RequestBody Map<String,String> userInfo) {
        if (sysUserService.selectUserByName(userInfo.get("username"))!=null){
            Map<String,Object>result = new HashMap<String,Object>();
            result.put("msg","用户名已存在");
            return ResultUtil.resultError(result);
        }
        else {
            SysUserEntity sysUserEntity = new SysUserEntity();
            sysUserEntity.setUsername(userInfo.get("username"));
            sysUserEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
            sysUserEntity.setStatus("NORMAL");
            sysUserService.save(sysUserEntity);
            SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
            sysUserRoleEntity.setRoleId(Long.valueOf(userInfo.get("role_id")));
            sysUserRoleEntity.setUserId(sysUserEntity.getUserId());
            sysUserRoleService.save(sysUserRoleEntity);
            Map<String,Object>result = new HashMap<String, Object>();
            result.put("msg","用户已创建");
            return ResultUtil.resultSuccess(result);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/info")
    public Map<String,Object> userLogin(){
        Map<String,Object>result = new HashMap<>();
        SelfUserEntity userDetails = SecurityUtil.getUserInfo();
        result.put("title","管理");
        result.put("data",userDetails);
        return ResultUtil.resultSuccess(result);
    }


}
