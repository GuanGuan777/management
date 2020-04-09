package com.syx.management.common.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {
    /**
     * 版本号
     *
     * @return 版本号
     */
    @AliasFor("value")
    String version() default "";
    /**
     * 版本号
     *
     * @return 版本号
     */
    @AliasFor("version")
    String value() default "";
}
