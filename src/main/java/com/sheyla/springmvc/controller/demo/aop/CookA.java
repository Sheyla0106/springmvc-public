package com.sheyla.springmvc.controller.demo.aop;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:44
 * @Modified By：
 * @Description:
 */
public class CookA implements Cook {
    public void make() {
        System.out.println("制作食品");
    }

    public void make(String name) {
        System.out.println("制作" + name);
    }

    public boolean smell(String name) {
        System.out.println(name + "香吗？");
        return true;
    }

}
