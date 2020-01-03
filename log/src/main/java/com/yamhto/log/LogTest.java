package com.yamhto.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author yamhto
 * @className: LogTest.java
 * @package com.yamhto.log
 * @description: log测试
 * @date 2019/12/23 14:11
 */
@Slf4j
@Component
public class LogTest {

    @Scheduled(cron = "0/1 * * * * ?")
    public void testLog(){
        log.error("level error ============");
        log.debug("level debug ============");
        log.info("level info ============");
        log.warn("level warn ============");
    }
}
