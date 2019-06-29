package com.sheyla.springmvc.controller.java8.repeatingannotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: sheyla
 * @Description:重复注解R注解
 * @Date:Create：in 2019/6/29 16:02
 * @Modified By：
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Categorys.class)
public @interface Category {
    String role();
}
