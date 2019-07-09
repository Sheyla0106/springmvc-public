package com.sheyla.springmvc.controller.demo.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:39
 * @Modified By：
 * @Description:
 */
public class NamePointcut {
    /**
     * 切点被命名为 method1，且该切点只能在本类中使用
     */
    @Pointcut("within(com.sheyla.springmvc.*)")
    private void method1() {
    }

    /**
     * 切点被命名为 method2，且该切点可以在本类或子孙类中使用
     */
    @Pointcut("within(com.sheyla.springmvc.*)")
    protected void method2() {
    }

    /**
     * 切点被命名为 method3，且该切点可以在任何类中使用
     * 这里还使用了复合运算
     */
    @Pointcut("method1() && method2()")
    public void method3() {
    }

}
