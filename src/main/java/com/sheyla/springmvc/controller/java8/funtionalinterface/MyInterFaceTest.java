package com.sheyla.springmvc.controller.java8.funtionalinterface;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/13 0:20
 * @Modified By：
 */
public class MyInterFaceTest {
    public static void main(String[] args) {
        MyInterface<String> myInterface = message -> System.out.println("Hello " + message);
        myInterface.accept("a");

        MyInterface01 myInterface01 = a -> a+"hi";
        System.out.println(myInterface01.add("b"));

    }
}
