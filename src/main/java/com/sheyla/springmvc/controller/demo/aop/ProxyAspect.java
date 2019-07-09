package com.sheyla.springmvc.controller.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:02
 * @Modified By：
 * @Description:
 */
@Aspect
public class ProxyAspect {

    @Before("this(cook)")
    public void bind(Cook cook) {
        System.out.println("--------绑定代理对象【开始】--------");
        System.out.println(cook.getClass().getName());
        System.out.println("--------绑定代理对象【结束】--------");
    }
}

