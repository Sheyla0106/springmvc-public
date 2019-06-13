package com.sheyla.springmvc.controller.demo.thread;

import com.sheyla.springmvc.bean.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 11:21
 * @Modified By：
 * 做减法，到0结束
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t  国，被灭");

                countDownLatch.countDown();
            }, CountryEnum.getById(i).getVal()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t###秦统一六国");


        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getKey());
        System.out.println(CountryEnum.ONE.getVal());

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 自习完，离开教室");

                countDownLatch.countDown();
                }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t###班长最后走，锁门离开教室");


    }
}
