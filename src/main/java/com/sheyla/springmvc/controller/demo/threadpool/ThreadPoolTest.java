package com.sheyla.springmvc.controller.demo.threadpool;

import java.util.concurrent.*;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/12 0:15
 * @Modified By：
 * @Description:
 */
public class ThreadPoolTest {
    public static void main(String[] args) {

        //cachePooltest();
        //newFixedThreadPool();

        //myExecutor();

        //myPool();

        ExecutorService executorService = new ThreadPoolExecutor(16, 16,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(20), new NamedThreadFactory("测试", "-测试线程-"));

        //设置核心线程空闲能自己关了
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
        for (int i = 0; i < 100; i++) {
            try {
                executorService.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 执行");

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 执行结束");

                });
            } catch (RejectedExecutionException e) {
                System.out.println("\t" + e.getMessage());
            }


        }

    }

    private static void myPool() {
        ExecutorService myExecutor = new ThreadPoolExecutor(16, 16,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new NamedThreadFactory("测试", "-测试线程-"));

        //设置核心线程空闲能自己关了
        ((ThreadPoolExecutor) myExecutor).allowCoreThreadTimeOut(true);
        for (int i = 0; i < 100; i++) {

            myExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 执行");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 执行结束");

            });

        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t 全部完成");
    }

    /**
     * 核心数为0，也会正常使用线程池
     */

    private static void myExecutor() {
        ExecutorService myExecutor = new ThreadPoolExecutor(0, 100,
                10, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(100));

        for (int i = 0; i < 10; i++) {

            myExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 执行");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 执行结束");

            });

        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t 全部完成");
    }

    /**
     * newFixedThreadPool 线程池不会关闭
     */
    private static void newFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 100; i++) {

            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 执行");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 执行结束");

            });

        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t 全部完成");
    }

    /**
     * 测试newCachedThreadPool
     * <p>
     * 开了100个线程，到60秒后结束
     */
    private static void cachePooltest() {
        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 100; i++) {

            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 执行");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 执行结束");

            });

        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t 全部完成");
    }

}
