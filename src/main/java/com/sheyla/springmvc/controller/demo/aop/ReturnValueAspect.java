package com.sheyla.springmvc.controller.demo.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:06
 * @Modified By：
 * @Description:
 */
@Aspect
public class ReturnValueAspect {

    @AfterReturning(value = "target(com.sheyla.springmvc.controller.demo.aop.CookA)", returning = "value")
    public void bind(boolean value) {
        System.out.println("绑定返回值【开始】");
        System.out.println("value：" + value);
        System.out.println("绑定返回值【结束】");
    }
}

