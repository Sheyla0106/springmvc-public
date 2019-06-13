package com.sheyla.springmvc.controller.java8.futrue;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 1:00
 * @Modified By：
 */
public class ColdDishThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

