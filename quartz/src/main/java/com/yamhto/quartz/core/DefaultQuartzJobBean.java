package com.yamhto.quartz.core;

import com.yamhto.quartz.log.Log;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author yamhto
 * @className: DefaultQuartzJobBean.java
 * @package com.yamhto.quartz.core
 * @description: 默认的Job执行器
 * @date 2019/12/23 13:52
 */
public class DefaultQuartzJobBean extends QuartzJobBean implements Log {

    @Override
    protected void executeInternal(JobExecutionContext executionContext) throws JobExecutionException {
        // 拿到Spring的上下文，可以自由的做业务处理
        try {
            ApplicationContext applicationContext = (ApplicationContext)
                    executionContext.getScheduler().getContext().get("applicationContext");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        TriggerKey key = executionContext.getTrigger().getKey();
        String group = key.getGroup();
        String name = key.getName();
        // 业务处理 ...

        log.info(Thread.currentThread() + " 执行中 ... " + group + "\t" + name);
    }
}
