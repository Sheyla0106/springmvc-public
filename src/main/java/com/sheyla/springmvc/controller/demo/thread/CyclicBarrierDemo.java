package com.sheyla.springmvc.controller.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 13:20
 * @Modified By：
 * 做加法，到一个数，结束
 * <p>
 * 人到齐，吃饭
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println(Thread.currentThread().getName() + "\t ###召唤神龙");

        });
        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t  收集：" + tempInt + "龙珠");
                try {
                    //先到先等，被阻塞
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }, String.valueOf(i)).start();
        }



    }
}
