package com.macfu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liming
 * @Date: 2018/11/19 17:42
 * @Description: thumbRedis工具类
 */
@Component
public class ThumbRedisUtils {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setString(String key, String value, Long expired, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, expired, timeUnit);
    }
}
