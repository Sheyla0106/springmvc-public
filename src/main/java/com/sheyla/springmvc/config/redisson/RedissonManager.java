package com.sheyla.springmvc.config.redisson;

import org.redisson.Redisson;
import org.redisson.config.Config;

/**
 * @Author: sheyla
 * @Description:redis锁的配置类，单机版
 * @Date:Create：in 2019/6/25 0:03
 * @Modified By：静态内部类实现单例
 */
public class RedissonManager {
    private static Config config = new Config();
    //声明redisso对象
    private static Redisson redisson = null;

    //实例化redisson
    static {
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        config.useSingleServer().setPassword("123456");
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);

    }

    //获取redisson对象的方法
    public static Redisson getRedisson() {
        return redisson;
    }
}
