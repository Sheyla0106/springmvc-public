package com.sheyla.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @descriptor: 第一个controller
 */
@Controller
@RequestMapping("/hi")
public class HiController {

    /**
     * 打招呼
     * @return
     */
    @RequestMapping("/say")
    public String say() {
        return "say";
    }
}