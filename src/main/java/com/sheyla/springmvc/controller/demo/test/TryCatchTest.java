package com.sheyla.springmvc.controller.demo.test;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/8/11 15:00
 * @Modified By：
 * @Description: try-catch-finally控制
 * <p>
 * 1、try正常，catch异常，finally正常，返回finally的值
 * 2、try异常，catch异常，finally正常，返回finally的值
 * 3、try异常，catch异常，finally异常，程序报错
 * 4、finally异常，程序报错
 * <p>
 * 15. 为什么 finally 总能被执行？
 * 答：finally 总会被执行，都是编译器的作用，因为编译器在编译 Java 代码时，
 * 会复制 finally 代码块的内容，然后分别放在 try-catch 代码块所有的正常执行路径
 * 及异常执行路径的出口中，这样 finally 才会不管发生什么情况都会执行。
 */
public class TryCatchTest {
    public static void main(String[] args) {
        System.out.println(retrunVal());


    }

    private static int retrunVal() {
        int a = 1;
        try {
            a = 2;
            return 8;
        } catch (Exception e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            return a;
        }
    }
}
