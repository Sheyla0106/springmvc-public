package com.sheyla.springmvc.controller.demo.aop;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:56
 * @Modified By：
 * @Description:
 */
public class CookC implements Cook {
    public void make() {
        System.out.println("制作食品");
    }

    public void make(String name) {
        System.out.println("制作" + name);
    }

    public void make(String name, int num) {
        System.out.println("制作" + name + " " + num + " 个");
    }
}
