package com.sheyla.springmvc.controller.demo.singleton;

public class DCLSingleton {
    private static volatile DCLSingleton instance = null;

    private DCLSingleton() {

        System.out.println(Thread.currentThread().getName() + "  我是构造函数SingletonDemo，创建线程完成！");
    }

    /**
     * DCL double check lock 双端检查机制
     * 同步代码段  指令重拍 +禁止指令重排 valolite
     * 问题：
     * instance=new SingletonDemo()
     *
     * @return
     */
    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
            //instance = new DCLSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                DCLSingleton.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
