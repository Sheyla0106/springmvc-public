package com.sheyla.springmvc.controller.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:57
 * @Modified By：
 * @Description:
 */
@Aspect
public class ParamsAspect {

    @Before("target(com.sheyla.springmvc.controller.demo.aop.CookC) && args(name,num,..)")
    public void test(String name, int num) {
        System.out.println("----------绑定连接点入参【开始】----------");
        System.out.println("name:" + name);
        System.out.println("num:" + num);
        System.out.println("----------绑定连接点入参【结束】----------");

    }
}

