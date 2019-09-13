package com.sheyla.springmvc.controller.demo.test;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/28 12:11
 * @Modified By：
 * @Description:
 */
public class SwitchTest {

    public static void main(String[] args) {
        testOne();
    }

    public static void testOne() {
        int one = 1;
        int two = one + one;
        System.out.printf("Two=%d", two);
    }

    private static void getSwitch(String param) {
        switch (param) {
            case "param":
                System.out.println("param");
                break;
            case "String":
                System.out.println("String");
                break;
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
