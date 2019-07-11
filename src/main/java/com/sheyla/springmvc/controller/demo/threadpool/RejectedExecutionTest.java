package com.sheyla.springmvc.controller.demo.threadpool;

import com.sheyla.springmvc.controller.demo.threadpool.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/12 1:20
 * @Modified By：
 * @Description: 说明：
 * 一、默认策略：AbortPolicy
 * 1、当线程池处理不了抛异常，使用CountDownLatch设置要注意，达不到等于0的状态
 * 2、返回结果
 * 处理成功条数	36,处理失败条数	64
 * <p>
 * 二、调用者处理new ThreadPoolExecutor.CallerRunsPolicy()
 * 1、使用main函数处理订单
 * 2，返回结果
 * 处理成功条数	100,处理失败条数	0
 * <p>
 * <p>
 * 三、 new ThreadPoolExecutor.DiscardPolicy
 * 1、没有异常，直接丢弃
 * * 2、 处理成功条数	36,处理失败条数	0,未处理：64
 * * <p>
 * * 四、 new ThreadPoolExecutor.DiscardOldestPolicy()
 * * 1、没有异常，找最老的直接丢弃
 * 2、结果
 * 处理成功条数	36,处理失败条数	0,未处理：64
 * <p>
 * 五、自定义拒绝策略MyRejectPolicy implements RejectedExecutionHandler
 * 1、实现方法rejectedExecution
 */
public class RejectedExecutionTest {
    private static List<OrderBean> orderBeanList = new ArrayList<>();
    private static Integer orderNum = 100;

    static {
        for (int i = 0; i < orderNum; i++) {
            OrderBean orderBean = new OrderBean();
            orderBean.setOrderNo(UUID.randomUUID().toString().substring(0, 8));
            orderBean.setProcessCount(0);
            orderBean.setProcessStatus(0);
            orderBean.setSrc("A");
            orderBeanList.add(orderBean);

        }
    }

    public static void main(String[] args) throws InterruptedException {

        //discardPolicy();
        //abortPolicy();
        //callerRunsPolicy();

        //discardOldestPolicy();
        myRejectHandlr();
    }

    private static void myRejectHandlr() {
        ExecutorService executorService = new ThreadPoolExecutor(16, 16,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(20), new NamedThreadFactory("测试", "-测试线程-"), new MyRejectPolicy());

        //设置核心线程空闲能自己关了
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);

        AtomicInteger sucessNum = new AtomicInteger();
        AtomicInteger failNum = new AtomicInteger();

        for (OrderBean orderBean : orderBeanList) {

            try {
                executorService.submit(new OrderTask(orderBean));
                sucessNum.incrementAndGet();
            } catch (Exception e) {
                failNum.getAndIncrement();
                orderBean.setProcessStatus(4);
                System.out.println(Thread.currentThread().getName() + "\t订单号处理失败\t" + orderBean.getOrderNo());
            }
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        System.out.println(" 处理成功条数\t" + sucessNum.get() + ",处理失败条数\t" + failNum.get());

        int s = 0;
        int f = 0;
        int u = 0;
        int init = 0;
        for (OrderBean orderBean : orderBeanList) {
            if (orderBean.getProcessStatus() == 3) {
                s++;
            } else if (orderBean.getProcessStatus() == 4) {
                f++;
            } else if (orderBean.getProcessStatus() == 0) {
                u++;
            }
            System.out.println(orderBean);

        }
        System.out.println(" 处理成功条数\t" + s + ",处理失败条数\t" + f + ",未处理：" + u);
    }

    private static void discardOldestPolicy() {
        ExecutorService executorService = new ThreadPoolExecutor(16, 16,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(20), new NamedThreadFactory("测试", "-测试线程-"), new ThreadPoolExecutor.DiscardOldestPolicy());

        //设置核心线程空闲能自己关了
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);

        AtomicInteger sucessNum = new AtomicInteger();
        AtomicInteger failNum = new AtomicInteger();

        for (OrderBean orderBean : orderBeanList) {

            try {
                executorService.submit(new OrderTask(orderBean));
                sucessNum.incrementAndGet();
            } catch (Exception e) {
                failNum.getAndIncrement();
                orderBean.setProcessStatus(4);
                System.out.println(Thread.currentThread().getName() + "\t订单号处理失败\t" + orderBean.getOrderNo());
            }
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        System.out.println(" 处理成功条数\t" + sucessNum.get() + ",处理失败条数\t" + failNum.get());

        int s = 0;
        int f = 0;
        int u = 0;
        int init = 0;
        for (OrderBean orderBean : orderBeanList) {
            if (orderBean.getProcessStatus() == 3) {
                s++;
            } else if (orderBean.getProcessStatus() == 4) {
                f++;
            } else if (orderBean.getProcessStatus() == 0) {
                u++;
            }
            System.out.println(orderBean);

        }
        System.out.println(" 处理成功条数\t" + s + ",处理失败条数\t" + f + ",未处理：" + u);
    }

    private static void discardPolicy() {
        ExecutorService executorService = new ThreadPoolExecutor(16, 16,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(20), new NamedThreadFactory("测试", "-测试线程-"), new ThreadPoolExecutor.DiscardPolicy());

        //设置核心线程空闲能自己关了
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);

        AtomicInteger sucessNum = new AtomicInteger();
        AtomicInteger failNum = new AtomicInteger();

        for (OrderBean orderBean : orderBeanList) {

            try {
                executorService.submit(new OrderTask(orderBean));
                sucessNum.incrementAndGet();
            } catch (Exception e) {
                failNum.getAndIncrement();
                orderBean.setProcessStatus(4);
                System.out.println(Thread.currentThread().getName() + "\t订单号处理失败\t" + orderBean.getOrderNo());
            }
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        System.out.println(" 处理成功条数\t" + sucessNum.get() + ",处理失败条数\t" + failNum.get());

        int s = 0;
        int f = 0;
        int u = 0;
        int init = 0;
        for (OrderBean orderBean : orderBeanList) {
            if (orderBean.getProcessStatus() == 3) {
                s++;
            } else if (orderBean.getProcessStatus() == 4) {
                f++;
            } else if (orderBean.getProcessStatus() == 0) {
                u++;
            }
        }
        System.out.println(" 处理成功条数\t" + s + ",处理失败条数\t" + f + ",未处理：" + u);
    }

    private static void callerRunsPolicy() {
        ExecutorService executorService = new ThreadPoolExecutor(16, 16,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(20), new NamedThreadFactory("测试", "-测试线程-"), new ThreadPoolExecutor.CallerRunsPolicy());

        //设置核心线程空闲能自己关了
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);

        AtomicInteger sucessNum = new AtomicInteger();
        AtomicInteger failNum = new AtomicInteger();

        for (OrderBean orderBean : orderBeanList) {

            try {
                executorService.submit(new OrderTask(orderBean));
                sucessNum.incrementAndGet();
            } catch (RejectedExecutionException e) {
                failNum.getAndIncrement();
                orderBean.setProcessStatus(4);
                System.out.println(Thread.currentThread().getName() + "\t订单号处理失败\t" + orderBean.getOrderNo());
            }
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        System.out.println(" 处理成功条数\t" + sucessNum.get() + ",处理失败条数\t" + failNum.get());

        int s = 0;
        int f = 0;
        int u = 0;
        int init = 0;
        for (OrderBean orderBean : orderBeanList) {
            if (orderBean.getProcessStatus() == 3) {
                s++;
            } else if (orderBean.getProcessStatus() == 4) {
                f++;
            } else if (orderBean.getProcessStatus() == 0) {
                u++;
            }
        }
        System.out.println(" 处理成功条数\t" + s + ",处理失败条数\t" + f + ",未处理：" + u);
    }

    private static void abortPolicy() {
        ExecutorService executorService = new ThreadPoolExecutor(16, 16,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(20), new NamedThreadFactory("测试", "-测试线程-"));

        //设置核心线程空闲能自己关了
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);

        AtomicInteger sucessNum = new AtomicInteger();
        AtomicInteger failNum = new AtomicInteger();

        for (OrderBean orderBean : orderBeanList) {

            try {
                executorService.submit(new OrderTask(orderBean));
                sucessNum.incrementAndGet();
            } catch (RejectedExecutionException e) {
                failNum.getAndIncrement();
                orderBean.setProcessStatus(4);
                System.out.println(Thread.currentThread().getName() + "\t订单号处理失败\t" + orderBean.getOrderNo());
            }
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }


        System.out.println(" 处理成功条数\t" + sucessNum.get() + ",处理失败条数\t" + failNum.get());

        int s = 0;
        int f = 0;
        int u = 0;
        int init = 0;
        for (OrderBean orderBean : orderBeanList) {
            if (orderBean.getProcessStatus() == 3) {
                s++;
            } else if (orderBean.getProcessStatus() == 4) {
                f++;
            } else if (orderBean.getProcessStatus() == 0) {
                u++;
            }
        }
        System.out.println(" 处理成功条数\t" + s + ",处理失败条数\t" + f + ",未处理：" + u);
    }
}
