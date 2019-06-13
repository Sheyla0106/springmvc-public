package com.sheyla.springmvc.controller.java8.funtionalinterface;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/13 0:20
 * @Modified By：
 *
 * * 函数式接口
 *  * 1、只有一个抽象的接口，其他接口都有默认实现
 *  * 2、函数式接口里允许定义java.lang.Object里的public方法
 *  * 3、函数式接口里允许定义静态方法
 */
@FunctionalInterface
public interface MyInterface<T> {
    void accept(T t);


    boolean equals(Object anObject);
}
