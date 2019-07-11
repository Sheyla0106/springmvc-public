package com.sheyla.springmvc.controller.demo.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/12 2:06
 * @Modified By：
 * @Description:
 */
public class MyRejectPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(executor);
    }
}
