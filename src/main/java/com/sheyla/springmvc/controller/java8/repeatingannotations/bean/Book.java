package com.sheyla.springmvc.controller.java8.repeatingannotations.bean;

import com.sheyla.springmvc.controller.java8.repeatingannotations.Category;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/29 16:04
 * @Modified By：
 */
public class Book {
    @Category(role = "manger")
    @Category(role = "math")
    private String auth;
    private String name;
    private Integer price;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
