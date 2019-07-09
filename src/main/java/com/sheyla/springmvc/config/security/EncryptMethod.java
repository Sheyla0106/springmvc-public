package com.sheyla.springmvc.config.security;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:27
 * @Modified By：
 * @Description: 安全字段注解
 * * 加在需要加密/解密的方法上
 * * 实现自动加密解密
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface EncryptMethod {
}
