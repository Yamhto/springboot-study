package com.yamhto.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yamhto.api.DubboServiceApi;
import com.yamhto.redis.config.redisConfig;
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
    public String dubbo(){
        dubboService.service();
        return "dubbo";
    }
}
