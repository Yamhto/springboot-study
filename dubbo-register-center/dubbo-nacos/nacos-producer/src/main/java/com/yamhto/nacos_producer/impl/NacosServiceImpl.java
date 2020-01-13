package com.yamhto.nacos_producer.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yamhto.dubbo.api.nacos.NacosServiceApi;

/**
 * @author yamhto
 * @className: NacosServiceImpl.java
 * @package com.yamhto.nacos_producer.impl
 * @description:
 * @date 2020/1/13 17:23
 */
@Service
public class NacosServiceImpl implements NacosServiceApi {
    @Override
    public void service() {
        System.out.println("Nacos service is invoking");
    }
}
