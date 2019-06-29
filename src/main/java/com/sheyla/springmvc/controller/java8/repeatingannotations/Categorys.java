package com.sheyla.springmvc.controller.java8.repeatingannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: sheyla
 * @Description: 只能是一个值为value的，切返回类型为Category
 * @Date:Create：in 2019/6/29 16:16
 * @Modified By：
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Categorys {
    Category[] value();
}
