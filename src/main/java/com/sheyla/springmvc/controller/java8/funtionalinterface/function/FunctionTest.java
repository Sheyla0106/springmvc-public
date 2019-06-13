package com.sheyla.springmvc.controller.java8.funtionalinterface.function;

import java.util.function.Function;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/12 23:35
 * @Modified By：
 * T 入参，R出参
 * R apply(T t)
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 2;

        System.out.println(f.apply(1));
        /**
         * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
         * 相当于以下代码：
         * Integer a = g.apply(1);
         * System.out.println(f.apply(a));
         * 先执行compose里面的
         * (V v) -> apply(before.apply(v))
         * before=g
         * 先执行g 函数，入参为1，，出参数为2.
         * 再置行f，入参为2，出参为3
         *    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
         *         Objects.requireNonNull(before);
         *         return (V v) -> apply(before.apply(v));
         *     }
         */
        System.out.println(f.compose(g).apply(1));

        /**
         * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
         * 相当于以下代码
         * Integer a = f.apply(1);
         * System.out.println(g.apply(a));
         * (T t) -> after.apply(apply(t))
         * after=g
         * 先执行f，入参为1，出参为2
         * 再执行g，入参为2，出参为4
         *  default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
         *         Objects.requireNonNull(after);
         *         return (T t) -> after.apply(apply(t));
         *     }
         */
        System.out.println(f.andThen(g).apply(1));

        /**
         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
         * t -> t;
         *
         */
        System.out.println(Function.identity().apply("a"));

    }
}
