package com.yamhto.zk_producer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yamhto
 * @className: com.yamhto.redis.Application.java
 * @package PACKAGE_NAME
 * @description:
 * @date 2019/12/18 15:14
 */
@SpringBootApplication
@EnableDubbo
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
