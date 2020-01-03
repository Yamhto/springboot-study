package com.yamhto.springSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yamhto
 * @className: Application.java
 * @package com.yamhto.quartz
 * @description: spring schedule
 * @date 2019/12/20 15:31
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
