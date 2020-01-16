package com.yamhto.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yamhto
 * @className: Application.java
 * @package com.yamhto.admin.server
 * @description:
 * @date 2020/1/16 15:34
 */
@SpringBootApplication
@EnableAdminServer
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
