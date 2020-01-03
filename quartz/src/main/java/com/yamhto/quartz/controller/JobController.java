package com.yamhto.quartz.controller;

import com.yamhto.api.schedule.IQuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yamhto
 * @className: JobController.java
 * @package com.yamhto.quartz.controller
 * @description:
 * @date 2019/12/23 17:24
 */
@RestController
public class JobController {

    @Autowired
    public IQuartzService quartzService;

    @RequestMapping("/hello")
    public String hi(){
        return "hello";
    }


    @RequestMapping("/job")
    public String start() {

        try {
            quartzService.addJob("job2", "group1", "0/1 * * * * ?");

            return "启动定时器成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

    @RequestMapping("/pause")
    public String pause() {

        try {
            quartzService.pauseJob("job1", "group1");

            return "job1暂停成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "job1暂停失败";
    }

    @RequestMapping("/resume")
    public String resume() {

        try {
            quartzService.resumeJob("job1", "group1");

            return "job1重启成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "job1重启失败";
    }


}
