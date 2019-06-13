package com.sheyla.springmvc.controller.demo.singleton;

public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {

        System.out.println(Thread.currentThread().getName() + "  我是构造函数SingletonDemo，创建线程完成！");
    }

    /**
     * synchronized 一次只有一个线程执行该方法 比较重 并发情况不太好
     *
     * @return
     */
    public static synchronized SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    /**
     * DCL double check lock 双端检查机制
     * 同步代码段  指令重拍 +禁止指令重排 volatile
     * 1、分配空间
     * 2、设置值
     * 3、指向位置
     * 问题：
     *    instance=new SingletonDemo()
     *     第一个线程进入到系统 指向位置，没有设置值。此时位置出去了，内容为空
     *     第二线程返回，位置出去了，内容为空造成问题
     *
     *     解决办法，使用volatile声明禁止指令重排
     *
     * @return
     */
    public static SingletonDemo getInstance01() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //创建线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //SingletonDemo.getInstance();
                SingletonDemo.getInstance01();
            }, String.valueOf(i)).start();
        }
    }
}
