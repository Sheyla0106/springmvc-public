package com.sheyla.springmvc.controller.demo.threadpool;

import com.sheyla.springmvc.controller.demo.threadpool.bean.OrderBean;
import io.netty.util.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/12 1:27
 * @Modified By：
 * @Description:
 */
public class OrderTask implements Runnable {
    private OrderBean orderBean;

    OrderTask(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t处理的订单号\t" + orderBean.getOrderNo());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderBean.setProcessCount(orderBean.getProcessStatus() + 1);
        orderBean.setProcessStatus(3);
        System.out.println(Thread.currentThread().getName() + "\t处理的成功订单号\t" + orderBean.getOrderNo());

    }
}
