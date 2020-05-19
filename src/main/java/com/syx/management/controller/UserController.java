package com.syx.management.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.syx.management.common.utils.ResultUtil;
import com.syx.management.common.utils.SecurityUtil;
import com.syx.management.core.entity.BaseResponse;
import com.syx.management.core.entity.SysUserEntity;
import com.syx.management.core.entity.SysUserRoleEntity;
import com.syx.management.core.entity.user.Admin;
import com.syx.management.core.entity.user.Student;
import com.syx.management.core.entity.user.Teacher;
import com.syx.management.core.service.AdminService;
import com.syx.management.core.service.StudentService;
import com.syx.management.core.service.SysMenuService;
import com.syx.management.core.service.SysRoleService;
import com.syx.management.core.service.SysUserRoleService;
import com.syx.management.core.service.SysUserService;
import com.syx.management.core.service.TeacherService;
import com.syx.management.core.service.UserService;
import com.syx.management.security.entity.SelfUserEntity;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

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
    private AdminService adminService;

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Resource
    private SysMenuService sysMenuService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserController() {
    }

    // ADMIN 1 STUDENT 2 TEACHER 3
    @PostMapping("")
    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> AddUser(@RequestBody Map<String, String> userInfo) {
        if (sysUserService.selectUserByName(userInfo.get("username")) != null) {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("msg", "用户名已存在");
            return ResultUtil.resultError(result);
        } else {
            SysUserEntity sysUserEntity = new SysUserEntity();
            sysUserEntity.setUsername(userInfo.get("username"));
            sysUserEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
            sysUserEntity.setStatus("NORMAL");
            sysUserService.save(sysUserEntity);
            SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
            sysUserRoleEntity.setRoleId(Long.valueOf(userInfo.get("role_id")));
            sysUserRoleEntity.setUserId(sysUserEntity.getUserId());
            sysUserRoleService.save(sysUserRoleEntity);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("msg", "用户已创建");
            return ResultUtil.resultSuccess(result);
        }
    }


    @GetMapping("")
    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> getUsers(@RequestParam("role") String role) {
        Map<String, Object> result = new HashMap<String, Object>();
            if (role.equals("ADMIN")) {
                List<Admin>admins = adminService.list();
                result.put("data", admins);
            } else if (role.equals("STUDENT")) {
                List<Student>students = studentService.list();
                result.put("data", students);
            } else if (role.equals("TEACHER")) {
                List<Teacher>teachers = teacherService.list();
                result.put("data", teachers);
            }
            result.put("msg", "成功查询");
            return ResultUtil.resultSuccess(result);
    }

    @GetMapping(value = "/info")
    //  @PreAuthorize("hasAnyRole['ADMIN,STUDENT,TEACHER']")
    public Map<String, Object> getUserInfo() {
        Date date = new Date(1586188800000L);
        log.info(date.toString());
        Map<String, Object> result = new HashMap<>();
        SelfUserEntity userDetails = SecurityUtil.getUserInfo();
        try {
            if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
                Admin admin = adminService.findAdminByUserId(userDetails.getUserId());
                result.put("data", admin);
            } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
                Student student = studentService.findStudentdByUserId(userDetails.getUserId());
                result.put("data", student);
            } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_TEACHER"))) {
                Teacher teacher = teacherService.findTeacherByUserId(userDetails.getUserId());
                result.put("data", teacher);
            }
        } catch (Exception e) {
            log.error(e.toString());
            result.put("msg", "没有此用户");
            return ResultUtil.resultError(result);
        }
        result.put("title", "获取用户信息");
        return ResultUtil.resultSuccess(result);
    }


}
