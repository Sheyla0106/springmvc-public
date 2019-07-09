package com.sheyla.springmvc.controller.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:45
 * @Modified By：
 * @Description:
 */
@Aspect
public class JoinPointAspect {

    @Around("within(com.sheyla.springmvc.controller.demo.aop.CookA)")
    public void test(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("---------获取连接点对象【开始】---------");
        System.out.println("参数：");
        System.out.println("签名对象：" + pjp.getTarget().getClass());

        //执行目标对象方法
        pjp.proceed();
        System.out.println("---------获取连接点对象【结束】---------");

    }
}

