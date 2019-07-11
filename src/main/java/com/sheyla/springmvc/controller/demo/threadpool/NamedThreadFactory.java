package com.sheyla.springmvc.controller.demo.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/12 0:45
 * @Modified By：
 * @Description:可以自己定义名字的线程工厂
 */
public class NamedThreadFactory implements ThreadFactory {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    NamedThreadFactory(String poolName) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (null == poolName || poolName.isEmpty()) {
            poolName = "pool";
        }

        namePrefix = poolName + "-" + poolNumber.getAndIncrement() + "-thread-";

    }

    NamedThreadFactory(String poolName, String threadName) {

        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (null == poolName || poolName.isEmpty()) {
            poolName = "pool";
        }
        if (null == threadName || threadName.isEmpty()) {
            threadName = "-thread-";
        }
        namePrefix = poolName + "-" + poolNumber.getAndIncrement() + threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }

}
