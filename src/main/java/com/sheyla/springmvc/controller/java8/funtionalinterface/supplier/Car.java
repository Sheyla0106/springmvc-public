package com.sheyla.springmvc.controller.java8.funtionalinterface.supplier;

import java.util.function.Supplier;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 0:48
 * @Modified By：
 * Supplier接口产生一个给定类型的结果。Supplier没有输入参数。
 */
public class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    @Override
    public String toString() {
        return "Car{}";
    }
}
