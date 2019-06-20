package com.sheyla.springmvc.controller.demo.thread.threadlocal;

import com.sheyla.springmvc.bean.user.UserBean;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/21 1:08
 * @Modified By：
 * 不设置set，就get报空指针的例子
 * <p>
 * 可是为何ThreadLocalTest可以有一个为空呢？
 * <p>
 * 返回类型为long报错
 * <p>
 * public Long getLong() {
 * return longLocal.get();
 * }
 */
public class ThreadLocalTest01 {
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

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public UserBean getUser() {
        return userBeanThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest01 test = new ThreadLocalTest01();

        //主线程设置线程本地变量
        //test.set();
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
