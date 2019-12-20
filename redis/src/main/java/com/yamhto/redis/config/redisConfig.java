package com.yamhto.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yamhto
 * @className: redisConfig.java
 * @package com.yamhto.redis.config
 * @description: Redis 连接
 * @date 2019/12/18 15:05
 */
@Configuration
public class redisConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public RedissonClient getRedission(){
        Config config = new Config();
        String redisUrl = String.format("redis://%s:%s",redisProperties.getHost()+"",redisProperties.getPort()+"");
        config.useSingleServer().setAddress(redisUrl).setPassword(redisProperties.getPassword());
        config.useSingleServer().setDatabase(redisProperties.getDatabase());
        return Redisson.create(config);
    }
}
