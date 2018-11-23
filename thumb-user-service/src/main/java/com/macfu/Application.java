package com.macfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: liming
 * @Date: 2018/11/13 11:16
 * @Description: 主程序启动类
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.macfu.mapper"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.macfu")
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
