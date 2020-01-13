package com.yamhto.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yamhto.dubbo.api.DubboServiceApi;
import com.yamhto.dubbo.api.nacos.NacosServiceApi;
import com.yamhto.dubbo.api.schedule.IQuartzService;
import com.yamhto.redis.config.redisConfig;
import org.quartz.SchedulerException;
import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yamhto
 * @className: HelloController.java
 * @package com.yamhto.web.controller
 * @description:
 * @date 2019/12/18 14:46
 */
@RestController
public class HelloController {

    @Autowired
    private redisConfig redisConfig;

    @Reference
    private DubboServiceApi dubboService;

    @Reference
    private NacosServiceApi nacosService;

    @Reference
    public IQuartzService service;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/redis")
    public String redis() {
        RBucket<Object> hello = redisConfig.getRedission().getBucket("hello");
        hello.set("world");

        System.out.println(hello.get());

        return "succ";
    }

    @RequestMapping("/dubbo")
    public String dubbo() {
        dubboService.service();
        return "dubbo";
    }

    @RequestMapping("/nacos")
    public String nacos() {
        nacosService.service();
        return "nacos";
    }

    @RequestMapping(value = "/job")
    public String scheduleJob() {
        try {
            service.addJob("job", "group", "0/5 * * * * ?");
            return "启动定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

}
