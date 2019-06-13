package com.sheyla.springmvc.controller.java8.funtionalinterface.predicate;


import java.util.function.Predicate;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/13 0:02
 * @Modified By：
 * Represents a predicate (boolean-valued function) of one argument.
 * 预测一个参数是真还是假
 *
 * boolean test(T t);
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> g = o -> o.startsWith("t");
        /**
         * boolean test(T t);
         * T 入参，测试该函数是真假
         */
        System.out.println(p.test("a"));
        /**
         * (t) -> !test(t)
         * negate: 用于对原来的Predicate做取反处理；
         * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
         */
        System.out.println(p.negate().test("test"));

        /**
         * and: 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
         * (t) -> test(t) && other.test(t)
         */
        System.out.println(p.and(g).test("test"));

        /**
         * or: 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
         */
        System.out.println(p.or(g).test("ta"));

    }
}
