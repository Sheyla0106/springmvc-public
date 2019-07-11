package com.sheyla.springmvc.controller.demo.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 14:14
 * @Modified By：
 * 不存储元素的阻塞队列
 * <p>
 * 只有一个元素，多于一个就阻塞，知道被消费了
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();


        new Thread(() -> {

            try {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "\t take:" + blockingQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "\t take:" + blockingQueue.take());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "\t take:" + blockingQueue.take());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("程序执行时间：" + (System.currentTimeMillis() - start) + "毫秒");

    }
}
