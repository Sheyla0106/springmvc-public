package com.sheyla.springmvc.controller.demo.serializable.bean;

import java.io.Serializable;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/29 17:39
 * @Modified By：
 */
public class Tyre implements Serializable {
    private String tyreName;

    public String getTyreName() {
        return tyreName;
    }

    public void setTyreName(String tyreName) {
        this.tyreName = tyreName;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "tyreName='" + tyreName + '\'' +
                '}';
    }
}
