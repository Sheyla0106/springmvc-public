package com.sheyla.springmvc.controller.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 0:15
 * @Modified By：
 * 一、公平和非公平锁
 * 定义：
 * 公平，多个线程申请锁的顺序来获取锁，先来后到
 * 非公平，多线程获取锁的顺序并不是按照申请锁的顺序，有可能后申请的先获取锁
 * 在高并发情况下，可能造成优先级反转或者饥饿现象
 * <p>
 * 区别：
 * 公平锁，并发环境，先看等待队列，为空，或者当前线程为等待队列的第一个锁，就占有。否则加入到等待队列，以后按照FIFO规则获取锁
 * <p>
 * 非公平锁，比较粗鲁，上来就尝试占有锁，如果失败，就采用类似公平锁方式
 * <p>
 * new ReentrantLock()默认非公平，非公平锁有点在于吞吐量比公平锁大
 * <p>
 *
 * 二、可重入锁（递归锁）
 * 定义：
 * 同一个线程在外层函数获取锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一个线程在外层获取锁时候，在进入内层方法会自动获取锁
 * <p>
 * 即：线程可以进入任何一个它已经拥有锁的同步代码块
 * <p>
 * case one synchronized 是一个可重入锁
 * t1	 invoked sendSMS()        --外层 在t1同一个线程在外层获取锁时候，在进入内层方法会自动获取锁
 * t1	 #####invoked sendEmail() --内层
 * t2	 invoked sendSMS()
 * t2	 #####invoked sendEmail()
 * <p>
 * <p>
 * case tow ReentrantLock 是一个可重入锁
 * t3	 invoked get()
 * t3	 ######invoked set()
 * t4	 invoked get()
 * t4	 ######invoked set()
 *
 * 要是lock比unlock多，线程不会结束，不释放
 * 要是lock比unlock少，报错 IllegalMonitorStateException
 * 所以lock要和unlock匹配
 * <p>
 * <p>
 * 可重入锁可以避免死锁
 * <p>
 * 死锁产生的必要四个条件：
 * 1、竞争同一资源
 * 2、循环请求（补充，头尾相接的循环等待资源）
 * 3、保持并申请
 * 4、不可剥夺
 * （1） 互斥条件：一个资源每次只能被一个进程使用。
 * （2） 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * （3） 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。
 * （4） 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 * <p>
 * <p>
 * 理论--》实践--》总结
 * <p>
 * 例子：
 * 大门锁--》自动获得获得厨房锁
 * /书房锁
 *
 * 三、自旋锁
 *   CAS思想
 *   定义：
 *    尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，
 *    这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗CPU
 *
 *    循环探查，先忙自己的事，然后时不时回来看看
 *
 * 四、独占锁（写锁）/共享锁（读锁）/互斥锁
 *
 * 定义：
 * 独占锁：一次只能被一个线程锁持有 synchronized 和ReentrantLock
 *
 * 共享锁：该多可以被多个线程持有
 *
 * ReentrantReadWriteLock 读锁是共享锁，写锁是独占锁
 * 读写的共享锁可保证并发读是非常高效的，读写、写读、写写过程是互斥的
 *
 * sync ---> lock ---> ReentrantReadWriteLock(读写分离)
 *
 */
public class MyLock {
    public static void main(String[] args) {

        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("================分割线==============");

        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();



    }
}

class Phone implements Runnable {
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t #####invoked sendEmail()");
    }

    Lock lock = new ReentrantLock();


    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } finally {
            lock.unlock();
        }

    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ######invoked set()");

        } finally {
            lock.unlock();
        }

    }
}
