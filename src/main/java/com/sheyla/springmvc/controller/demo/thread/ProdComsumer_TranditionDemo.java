package com.sheyla.springmvc.controller.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 14:42
 * @Modified By：
 * <p>
 * 1、线程    操作    资源类
 * <p>
 * 2、判断    干活    通知唤醒
 * <p>
 * 3、防止虚假唤醒线程  多线程要用while循环盘算
 * <p>
 * 为空，不能消费
 * 为满，不能生产
 */
public class ProdComsumer_TranditionDemo {
    public static void main(String[] args) {

        SharedData sharedData = new SharedData();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                try {
                    sharedData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "AAA").start();



        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                try {
                    sharedData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "BBB").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    sharedData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "DDD").start();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                try {
                    sharedData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, "CCC").start();
    }

}

class SharedData {

    private static int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //判断 第一个为false，可以生产
            while (num != 0) {
                //等待不能生产
                condition.await();
            }

            //2 干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //3 唤醒线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //判断 第一个为false，可以生产
            while (num == 0) {
                //等待不能生产
                condition.await();
            }

            //2 干活
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //3 唤醒线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
