package com.syx.management.core.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author haha
 * @Date 2020/4/6 下午 17:53
 * @Version 1.0
 **/

@Data
public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Integer role;
    private String permission;
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//    private String salt;
//    private String permission;
}
