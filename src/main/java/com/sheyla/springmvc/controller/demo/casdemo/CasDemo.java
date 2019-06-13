package com.sheyla.springmvc.controller.demo.casdemo;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/1 18:59
 *
 *
 * cas = compare and swap 比较并交换
 * CPU的并发原语 （原语操作系统用语范畴，由若干指令形成， 用于完成一个功能，中间不能打断，具有原子性，保证数据一致性=线程安全）
 *
 * 工作空间的值和主物理空间的值作比较，true 设置值；false 不设置值；
 *
 *   unsafe.compareAndSwapInt(this, valueOffset, expect, update)
 *   this 当前对象
 *   valueOffset 内存偏移量 （内存地址）
 *   expect 期待值
 *   update 更新值
 *   当前对象在内存地址，期待值为**修改为**
 *
 *   原因：1、使用Unsafe类，他是rt.jar（jdk自带runtime）中的，大部分为native方法，可以直接操作操作系统底层资源
 *        2、valueOffset 直接获取内存地址
 *        3、值value使用volatile修饰，使得线程可见
 *
 *  cas问题：
 *     1、自旋太久消耗CPU
 *     2、只能控制一个共享变量
 *     3、ABA问题  （狸猫换太子）时间差导致数据变化
 *
 *   cas--Unsafe--->cas底层原理（自旋）---》ABA问题-----》原子引用类型
 *
 *   解决ABA问题？
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,300)+"   current data is:"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,600)+"   current data is:"+atomicInteger.get());

        /*
           可以替换i++的线程安全版本
           cas（比较并交换直至成功）=自旋
         */
        atomicInteger.getAndSet(1);

    }
}
