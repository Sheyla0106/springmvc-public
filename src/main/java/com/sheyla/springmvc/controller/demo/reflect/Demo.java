package com.sheyla.springmvc.controller.demo.reflect;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/10/15 23:32
 * @Modified By：
 * @Description:
 */
public class Demo {
    private String name;

    private Integer age;

    public String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 静态方法
    public static void staticMd() {
        System.out.println("Static Method");
    }

    // 公共方法
    public void publicMd() {
        System.out.println("Public Method");
    }

    // 私有方法
    private void privateMd() {
        System.out.println("Private Method");
    }
}
