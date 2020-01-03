package com.yamhto.springSchedule.executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author yamhto
 * @className: QuartzAsycConfig.java
 * @package com.yamhto.quartz.config
 * @description: spring schedule 多线程并发执行定时任务
 * @date 2019/12/23 11:47
 */
@Configuration
public class QuartzAsycConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(5);

        taskRegistrar.setScheduler(executors);
    }
}
