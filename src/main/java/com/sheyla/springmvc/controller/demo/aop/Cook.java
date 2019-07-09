package com.sheyla.springmvc.controller.demo.aop;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 0:44
 * @Modified By：
 * @Description:
 */
public interface Cook {
    /**
     * 制作食品
     */
    void make();

    /**
     * 制作
     *
     * @param name 食品名称
     */
    void make(String name);
}
