package com.sheyla.springmvc.controller.demo.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 13:28
 * @Modified By：
 * 信号量、信号灯
 * 抢停车位
 * 一个用于多个共享资源互斥使用，另一个并发线程数的控制
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//3个停车位

        for (int i = 1; i <= 6; i++) {//6个车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t停车3s,离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }


            }, String.valueOf(i)).start();

        }

    }
}
