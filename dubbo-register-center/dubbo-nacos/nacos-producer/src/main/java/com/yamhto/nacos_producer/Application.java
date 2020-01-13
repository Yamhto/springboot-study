package com.yamhto.nacos_producer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yamhto
 * @className: Application.java
 * @package com.yamhto.nacos_producer
 * @description:
 * @date 2020/1/13 17:22
 */
@SpringBootApplication
@NacosPropertySource(dataId = "nacos", autoRefreshed = true)
@EnableDubbo
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

