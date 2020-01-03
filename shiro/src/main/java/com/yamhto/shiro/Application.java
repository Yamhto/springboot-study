package com.yamhto.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yamhto
 * @className: Application.java
 * @package com.yamhto.shiro
 * @description:
 * @date 2019/12/25 18:36
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.yamhto.shiro.mapper"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
