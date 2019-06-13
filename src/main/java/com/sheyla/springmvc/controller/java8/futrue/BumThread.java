package com.sheyla.springmvc.controller.java8.futrue;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 0:58
 * @Modified By：
 */
public class BumThread extends Thread {
    @Override
    public void run() {
        try {
            //模拟访问延迟
            Thread.sleep(3 * 1000);
            System.out.println("包子准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
