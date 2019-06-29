package com.sheyla.springmvc.controller.demo.serializable.bean;

import javax.xml.bind.PrintConversionEvent;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/29 17:37
 * @Modified By：
 */
public class Car implements Serializable {

    private String name;

    private Date birthDay;
    //final修饰为值引用，在序列化的文件中
    private final Integer carTyrNun = 4;
    //static 不参与序列化
    private static String master;
    //对象
    private Tyre tyre;
    //transient 不参与序列化
    private transient Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getCarTyrNun() {
        return carTyrNun;
    }

    public static String getMaster() {
        return master;
    }

    public static void setMaster(String master) {
        Car.master = master;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", carTyrNun=" + carTyrNun +
                ", price=" + price +
                ", master=" + master +
                ", tyre=" + tyre +
                '}';
    }
}
