package com.sheyla.springmvc.controller.demo.thread.threadlocal;

import com.sheyla.springmvc.bean.user.UserBean;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/21 0:53
 * @Modified By：
 * <p>
 * 在main线程中和thread1线程中，longLocal保存的副本值和stringLocal保存的副本值都不一样。
 * 最后一次在main线程再次打印副本值是为了证明在main线程中和thread1线程中的副本值确实是不同的
 * 总结一下：
 * <p>
 * 　　1）实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
 * <p>
 * 　　2）为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；
 * <p>
 * 　　3）在进行get之前，必须先set，否则会报空指针异常；
 * <p>
 * 　　    如果想在get之前不需要调用set就能正常访问的话，必须重写initialValue()方法。
 * <p>
 * 　　　 因为在上面的代码分析过程中，我们发现如果没有先set的话，即在map中查找不到对应的存储，
 * 则会通过调用setInitialValue方法返回i，
 * 而在setInitialValue方法中，
 * 有一个语句是T value = initialValue()，
 * 而默认情况下，initialValue方法返回的是null。
 * <p>
 * <p>
 * 步骤：
 * 1.获取当前线程的ThreadLocalMap对象threadLocals
 * 2.从map中获取线程存储的K-V Entry节点。
 * 3.从Entry节点获取存储的Value副本值返回。
 * 4.map为空的话返回初始值null，即线程变量副本为null，在使用时需要注意判断NullPointerException。
 * <p>
 * 每个线程都有一个线程本地Map对象，一个线程可以有多个线程本地的key，vaule
 * <p>
 * 每个Thread线程内部都有一个Map。
 * Map里面存储线程本地对象（key）和线程的变量副本（value）
 * 但是，Thread内部的Map是由ThreadLocal维护的，由ThreadLocal负责向map获取和设置线程的变量值。
 * <p>
 * 如此例子，每个线程有三个线程本地的值
 * <p>
 * Entry继承自WeakReference（弱引用，生命周期只能存活到下次GC前），但只有Key是弱引用类型的，Value并非弱引用。
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>() {

        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    ThreadLocal<UserBean> userBeanThreadLocal = new ThreadLocal<UserBean>() {
        protected UserBean initialValue() {
            UserBean u1 = new UserBean();
            u1.setId(12L);
            u1.setName("测试");
            return u1;
        }
    };

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Object getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public UserBean getUser() {
        return userBeanThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();
        //主线程设置线程本地变量
        // test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println(test.getUser());


        Thread thread1 = new Thread() {
            public void run() {
                //thread1设置线程本地变量
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
                System.out.println(test.getUser());
            }

            ;
        };
        thread1.start();
        //一直等待，指导线程结束
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
        System.out.println(test.getUser());
    }
}

