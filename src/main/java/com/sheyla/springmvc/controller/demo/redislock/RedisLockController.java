package com.sheyla.springmvc.controller.demo.redislock;

import com.sheyla.springmvc.common.exceptions.SellException;
import com.sheyla.springmvc.config.redisson.DistributedRedisLock;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/25 0:46
 * @Modified By：
 */
@RestController
@RequestMapping("redis")
public class RedisLockController {
    private static final int TIMEOUT = 10 * 1000;//超时时间 10s

    /**
     * 活动，特价，限量100000份
     */
    static Map<String, Integer> products;//模拟商品信息表
    static Map<String, Integer> stock;//模拟库存表
    static Map<String, String> orders;//模拟下单成功用户表

    static {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    private String queryMap(String productId) {//模拟查询数据库
        return "国庆活动，皮蛋特教，限量"
                + products.get(productId)
                + "份,还剩:" + stock.get(productId)
                + "份,该商品成功下单用户数:"
                + orders.size() + "人";
    }

    @ResponseBody
    @RequestMapping(value = "/{productId}", produces = "text/html; charset=utf-8")
    //@RequestMapping(value = "/{productId}")需要搭配mvc配置使用
    public String redder(@PathVariable String productId) throws IOException {
        String key = "test123";
        //加锁
        DistributedRedisLock.acquire(key);
        //执行具体业务逻辑
        //加锁
        /*long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(101, "很抱歉，人太多了，换个姿势再试试~~");
        }*/

        //1.查询该商品库存，为0则活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new SellException(100, "活动结束");
        } else {
            //2.下单
            orders.put(UUID.randomUUID().toString(), productId);
            //3.减库存
            stockNum = stockNum - 1;//不做处理的话，高并发下会出现超卖的情况，下单数，大于减库存的情况。虽然这里减了，但由于并发，减的库存还没存到map中去。新的并发拿到的是原来的库存
            try {
                Thread.sleep(100);//模拟减库存的处理时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        /*//解锁
        redisLock.unlock(productId, String.valueOf(time));*/
        //释放锁
        DistributedRedisLock.release(key);
        //返回结果
        return queryMap(productId);
    }

}
