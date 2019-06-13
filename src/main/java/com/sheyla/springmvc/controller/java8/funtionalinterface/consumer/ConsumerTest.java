package com.sheyla.springmvc.controller.java8.funtionalinterface.consumer;

import java.util.function.Consumer;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/12 23:50
 * @Modified By：
 * Consumer
 * 接收一个参数，没有返回值
 * void accept(T t);
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");
        /**
         * void accept(T t)
         * T 是入参，执行给定的参数
         */
        f.accept("abc");
        /**
         *  组合结果
         *  有顺序的执行结果，先执行f，再执行f2，如果f执行
         */
        f.andThen(f2).accept("abc");

        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f).andThen(f2).andThen(f).andThen(f2).accept("test1");
    }


}
