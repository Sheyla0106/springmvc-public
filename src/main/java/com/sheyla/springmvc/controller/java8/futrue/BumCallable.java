package com.sheyla.springmvc.controller.java8.futrue;

import java.util.concurrent.Callable;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 1:07
 * @Modified By：
 */
public class BumCallable implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            //模拟访问延迟
            Thread.sleep(3 * 1000);
            System.out.println("包子准备完毕中。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "包子准备完毕";
    }
}
