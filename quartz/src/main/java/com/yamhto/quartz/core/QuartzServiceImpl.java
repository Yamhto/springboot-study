package com.yamhto.quartz.core;

import com.yamhto.api.schedule.IQuartzService;
import com.yamhto.quartz.util.JobUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author yamhto
 * @className: QuartzServiceImpl.java
 * @package com.yamhto.quartz.core
 * @description:
 * @date 2019/12/23 13:47
 */
@Slf4j
@Service
public class QuartzServiceImpl implements IQuartzService {


    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @PostConstruct
    public void startScheduler() {
        try {
            schedulerFactoryBean.getScheduler().start();
            log.info(" 调度器启动了 ...");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addJob(String jobName, String jobGroupName, int jobTime, int runCount) throws Exception {
        log.info(" 新增一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + ",jobTime=" + jobTime + "," +
                "runCount=" + runCount);
        Date date = JobUtils.addJob(schedulerFactoryBean.getScheduler(), DefaultQuartzJobBean.class, jobName, jobGroupName, jobTime, runCount);
        log.info(" job任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + " 执行完成 . " + date);
    }

    @Override
    public void addJob(String jobName, String jobGroupName, String jobTime) throws Exception {
        log.info(" 新增一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + ",jobTime=" + jobTime);
        Date date = JobUtils.addJob(schedulerFactoryBean.getScheduler(), DefaultQuartzJobBean.class, jobName, jobGroupName, jobTime);
        log.info(" job任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + " 执行完成 . " + date);
    }

    /**
     * 修改 一个job的 时间表达式
     *
     * @param jobName
     * @param jobGroupName
     * @param jobTime
     */
    @Override
    public void updateJob(String jobName, String jobGroupName, String jobTime) throws Exception {
        log.info(" 修改一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + ",jobTime=" + jobTime);
        Date date = JobUtils.updateJob(schedulerFactoryBean.getScheduler(), jobName, jobGroupName, jobTime);
        log.info(" job任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + " 执行完成 . ");
    }

    /**
     * 删除任务一个job
     *
     * @param jobName      任务名称
     * @param jobGroupName 任务组名
     */
    @Override
    public void deleteJob(String jobName, String jobGroupName) throws Exception {
        log.info(" 删除一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + ",jobTime=");
        boolean result = JobUtils.deleteJob(schedulerFactoryBean.getScheduler(), jobName, jobGroupName);
        log.info(" job任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + " 执行完成." + result);
    }

    /**
     * 暂停一个job
     *
     * @param jobName
     * @param jobGroupName
     */
    @Override
    public void pauseJob(String jobName, String jobGroupName) throws Exception {
        log.info(" 暂停一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + ",jobTime=");
        JobUtils.pauseJob(schedulerFactoryBean.getScheduler(), jobName, jobGroupName);
        log.info(" job任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + " 执行完成.");
    }

    /**
     * 恢复一个job
     *
     * @param jobName
     * @param jobGroupName
     */
    @Override
    public void resumeJob(String jobName, String jobGroupName) throws Exception {
        log.info(" 恢复一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + ",jobTime=");
        JobUtils.resumeJob(schedulerFactoryBean.getScheduler(), jobName, jobGroupName);
        log.info(" 恢复一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + "执行完成");
    }

    /**
     * 立即执行一个job
     *
     * @param jobName
     * @param jobGroupName
     */
    @Override
    public void runAJobNow(String jobName, String jobGroupName) throws Exception {
        log.info(" 立即执行一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + ",jobTime=");
        JobUtils.runAJobNow(schedulerFactoryBean.getScheduler(), jobName, jobGroupName);
        log.info(" 立即执行一个任务 jobName=" + jobName + ",jobGroupName" + jobGroupName + "完成 ...");

    }
}
