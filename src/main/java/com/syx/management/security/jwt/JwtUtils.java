package com.syx.management.security.jwt;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.syx.management.common.config.JWTConfig;
import com.syx.management.security.entity.SelfUserEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName JwtUtils
 * @Description
 * @Author haha
 * @Date 2020/4/7 下午 17:36
 * @Version 1.0
 **/
@Slf4j
public class JwtUtils {
    public static String createAccessToken(SelfUserEntity user){
        // 登陆成功生成JWT
        String token = Jwts.builder()
                // 放入用户名和用户ID
                .setId(user.getUserId()+"")
                // 主题
                .setSubject(user.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("haha")
                // 自定义属性 放入用户拥有权限
                .claim("authorities", JSON.toJSONString(user.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                .compact();
        return token;

    }
}
