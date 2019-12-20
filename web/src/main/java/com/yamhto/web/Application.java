package com.yamhto.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yamhto
 * @className: Application.java
 * @package com.yamhto.web
 * @description:
 * @date 2019/12/18 14:44
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.yamhto"})
@EnableDubbo
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
