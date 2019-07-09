package com.sheyla.springmvc.config.security;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:28
 * @Modified By：
 * @Description:安全字段注解 * 加在需要加密/解密的字段上
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface EncryptField {
}
