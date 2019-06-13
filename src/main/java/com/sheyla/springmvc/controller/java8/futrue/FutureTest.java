package com.sheyla.springmvc.controller.java8.futrue;

import org.springframework.util.StopWatch;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 1:03
 * @Modified By：
 * 1、线程异步有顺序返回结果
 */
public class FutureTest {
    public static void main(String[] args) throws Exception {
        StopWatch stopWatch = new StopWatch("统一打印时间");
        long start = System.currentTimeMillis();

        stopWatch.start("任务一");
        // 等凉菜
        Callable ca1 = new Callable() {

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = new Callable() {

            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();
        //get()方法阻塞当前进程执行
        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间：" + (end - start));
        stopWatch.stop();


        System.out.println("======================================");

        stopWatch.start("任务二");
        FutureTask<String> futureTask01 = new FutureTask<String>(new BumCallable());
        FutureTask<String> futureTask02 = new FutureTask<String>(new ColdDishCallable());
        new Thread(futureTask01).start();
        new Thread(futureTask02).start();

        System.out.println(futureTask01.get());
        System.out.println(futureTask02.get());
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());

    }
}
