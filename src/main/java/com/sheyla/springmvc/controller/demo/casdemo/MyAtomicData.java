package com.sheyla.springmvc.controller.demo.casdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicData {


    static AtomicInteger atomicInteger=new AtomicInteger();
    public static void addData(){
        //num.incrementAndGet();
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j <1000 ; j++) {
                    addData();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"numV is:"+MyAtomicData.atomicInteger);
    }
}
