package com.sheyla.springmvc.controller.demo.thread.threadlocal;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/21 1:46
 * @Modified By：
 * <p>
 * 在任何异步程序中（包括异步I/O、非阻塞I/O），ThreadLocal的参数传递是不靠谱的，因为线程将请求发送后，就不再等待远程返回结果继续向下执行了，真正的返回结果得到后，处理的线程可能是另一个。
 *
 * ThreadLocal和Synchonized都用于解决多线程并发访问。但是ThreadLocal与synchronized有本质的区别。synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，这样就隔离了多个线程对数据的数据共享。而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享。
 *
 * Synchronized用于线程间的数据共享，而ThreadLocal则用于线程间的数据隔离。
 */
public class ThreadLocalTest02 {
    static class ResourceClass {

        public final static ThreadLocal<String> RESOURCE_1 =
                new ThreadLocal<String>();

        public final static ThreadLocal<String> RESOURCE_2 =
                new ThreadLocal<String>();

    }

    static class A {

        public void setOne(String value) {
            ResourceClass.RESOURCE_1.set(value);
        }

        public void setTwo(String value) {
            ResourceClass.RESOURCE_2.set(value);
        }
    }

    static class B {
        public void display() {
            System.out.println(Thread.currentThread().getName() + ResourceClass.RESOURCE_1.get()
                    + ":" + ResourceClass.RESOURCE_2.get());
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        for (int i = 0; i < 15; i++) {
            final String resouce1 = "线程-" + i;
            final String resouce2 = " value = (" + i + ")";
            new Thread() {
                public void run() {
                    try {
                        a.setOne(resouce1);
                        a.setTwo(resouce2);
                        b.display();
                    } finally {
                        ResourceClass.RESOURCE_1.remove();
                        ResourceClass.RESOURCE_2.remove();
                    }
                }
            }.start();
        }
    }
}
