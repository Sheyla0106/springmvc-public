package com.sheyla.springmvc.bean.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger {
    static AtomicInteger atomicInteger=new AtomicInteger();
    public void addData(){
        atomicInteger.getAndIncrement();
    }
}
