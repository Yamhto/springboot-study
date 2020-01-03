package com.yamhto.springSchedule.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author yamhto
 * @className: MyJob.java
 * @package com.yamhto.springSchedule.executor.job
 * @description: spring schedule job  @Scheduled
 * @date 2019/12/20 16:49
 */
@Component
public class MyJob {

    @Scheduled(cron = "0/1 * * * * ?")
    public void simpleJob() {
        System.out.println("start My Job：" + LocalDateTime.now() + Thread.currentThread());

        System.out.println("end  My Job：" + LocalDateTime.now() + Thread.currentThread());

    }

    @Scheduled(cron = "0/1 * * * * ?")
    public void test() {
        System.out.println("start the Job：" + LocalDateTime.now() + Thread.currentThread());

        System.out.println("end  the Job：" + LocalDateTime.now() + Thread.currentThread());

    }
}
