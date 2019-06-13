package com.sheyla.springmvc.controller.demo.casdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {
    private static int num=0;

    public static void addData(){
        num++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j <1000 ; j++) {
                    addData();
                }
            }, String.valueOf(i)).start();
        }
        //保证线程执行完
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"num is:"+MyData.num);
    }
}
