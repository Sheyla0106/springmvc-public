package com.sheyla.springmvc.controller.demo.aop.demo4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:04
 * @Modified By：
 * @Description:
 */
@Aspect
public class ClassAnnotationObjectAspect {

    @Before("@within(log)")
    public void bind(Log log) {
        System.out.println("----------绑定类注解对象【开始】----------");
        System.out.println(log.getClass().getName());
        System.out.println("----------绑定类注解对象【结束】----------");
    }
}

