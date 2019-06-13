package com.sheyla.springmvc.controller.demo.casdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/1 20:50
 * @Modified By：
 * <p>
 * 解决ABA问题  原子引用+版本号（类似时间戳）
 * <p>
 * AtomicStampedReference 原子时间戳引用
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    static AtomicStampedReference atomicStampedReference=new AtomicStampedReference(100,1);
    public static void main(String[] args) {
        System.out.println("=======================以下ABA问题演示======================");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            //暂停1秒t2线程，保证t1完成一次ABA的操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019)
                    + "\t" + atomicReference.get());

        }, "t2").start();


        System.out.println("=======================以下ABA问题解决======================");

        new Thread(() -> {
            int stamp=atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第1次版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第2次版本号："+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第3次版本号："+atomicStampedReference.getStamp());


        }, "t3").start();



        new Thread(() -> {
            int stamp=atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第1次版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result=atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t修改成功"+result+"\t  当前实际最新版本号:"+atomicStampedReference.getStamp());

            System.out.println(Thread.currentThread().getName()+"\t当前实际值："+atomicStampedReference.getReference());


        }, "t4").start();
    }
}
