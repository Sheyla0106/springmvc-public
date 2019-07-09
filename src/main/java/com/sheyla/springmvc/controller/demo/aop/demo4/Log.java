package com.sheyla.springmvc.controller.demo.aop.demo4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:03
 * @Modified By：
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)//保留期限
@Target({ElementType.METHOD, ElementType.TYPE})//目标类型
public @interface Log {
    boolean value() default true;//声明成员变量
}
