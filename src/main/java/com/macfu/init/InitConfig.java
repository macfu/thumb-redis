package com.macfu.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: liming
 * @Date: 2018/11/19 10:42
 * @Description: 启动加载数据类
 */
@Component
public class InitConfig implements CommandLineRunner {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public void run(String... strings) throws Exception {

    }
}
