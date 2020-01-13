package com.yamhto.zk_producer.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yamhto.dubbo.api.DubboServiceApi;

/**
 * @author yamhto
 * @className: DubboServiceImpl.java
 * @package com.yamhto.com.yamhto.zk_producer.impl
 * @description:
 * @date 2019/12/20 11:26
 */
@Service
public class DubboServiceImpl implements DubboServiceApi {

    @Override
    public void service() {
        System.out.println("服务调用开始。。。。");
    }
}
