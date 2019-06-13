package com.sheyla.springmvc.controller.demo.thread;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/1 23:41
 * @Modified By：
 * HashSet非线程安全
 */
public class ContainerNotSafeDemoSet {
    public static void main(String[] args) {
        //Set<String> set = new HashSet<>();

        //Set<String> set = Collections.synchronizedSet(new HashSet<>());

        //底层为CopyOnWriteArrayList
        Set<String> set =new CopyOnWriteArraySet<>();


        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }


    }
}
