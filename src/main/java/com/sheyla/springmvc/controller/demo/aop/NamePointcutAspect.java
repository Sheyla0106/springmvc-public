package com.sheyla.springmvc.controller.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:42
 * @Modified By：
 * @Description:
 */
@Aspect
public class NamePointcutAspect {
    @After("NamePointcut.method2()")
    public void aspectMethod1() {
    }

    /**
     * 这里使用了复合运算
     */
    @After("NamePointcut.method2() && NamePointcut.method3()")
    public void aspectMethod2() {
    }

}
