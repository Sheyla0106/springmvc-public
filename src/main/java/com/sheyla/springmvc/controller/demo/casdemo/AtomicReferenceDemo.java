package com.sheyla.springmvc.controller.demo.casdemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: sheyla
 * @Description:原子引用
 * @Date:Create：in 2019/6/1 20:37
 * @Modified By：
 *
 * 原子引用可以包装对象为原子类型
 * 解决ABA问题  原子引用+版本号（类似时间戳）
 *  *
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User u1 = new User("z3", 4);
        User u2 = new User("li4", 5);

        AtomicReference<User> atomicReference = new AtomicReference<>();

        atomicReference.set(u1);

        System.out.println(atomicReference.compareAndSet(u1, u2) + "   当前对象：" + atomicReference.get().toString()
        );
        System.out.println(atomicReference.compareAndSet(u1, u2) + "   当前对象：" + atomicReference.get().toString()
        );
    }
}


class User {
    String userName;
    int age;

    User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
