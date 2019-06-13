package com.sheyla.springmvc.controller.java8.futrue;

import java.util.concurrent.Callable;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 1:08
 * @Modified By：
 */
public class ColdDishCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕中。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "凉菜准备完毕";
    }
}
