package com.macfu.utils;

import java.util.Random;

/**
 * @Author: liming
 * @Date: 2018/11/19 16:16
 * @Description: 产生独一无二的key
 */
public class KeyUtils {
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        int num = random.nextInt(900000) + 100000;
        String key = System.currentTimeMillis() + String.valueOf(num);
        return MD5Utils.getMd5(key);
    }
}
