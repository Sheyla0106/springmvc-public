package com.sheyla.springmvc.controller.demo.aop;

import com.sheyla.springmvc.controller.demo.aop.demo4.CookD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:47
 * @Modified By：
 * @Description: AOPC测试
 * https://blog.csdn.net/deniro_li/article/details/81838197
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        CookA cook = (CookA) context.getBean("cookA");
        cook.make();
        CookC cookC = (CookC) context.getBean("cookC");
        cookC.make("寿司", 100);
        CookD cookd = (CookD) context.getBean("cookD");
        cookd.make();

        //cook.smell("烤鸭");

    }
}
