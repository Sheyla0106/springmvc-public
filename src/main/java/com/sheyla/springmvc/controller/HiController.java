package com.sheyla.springmvc.controller;

import com.sheyla.springmvc.common.exceptions.SellException;
import com.sheyla.springmvc.config.redisson.DistributedRedisLock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
 * @descriptor: 第一个controller
 */
@Controller
@RequestMapping("/hi")
public class HiController {


    /**
     * 打招呼
     *
     * @return
     */
    @RequestMapping("/say")
    public String say() {
        return "say";
    }


}