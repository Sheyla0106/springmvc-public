package com.sheyla.springmvc.controller.demo.aop.demo4;

import com.sheyla.springmvc.controller.demo.aop.Cook;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/7/10 1:04
 * @Modified By：
 * @Description:
 */
@Log
public class CookD implements Cook {
    public void make() {
        System.out.println("制作糕点");
    }

    public void make(String name) {

    }
}

