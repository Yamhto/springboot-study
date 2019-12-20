package com.yamhto.producer.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yamhto.api.DubboServiceApi;

/**
 * @author yamhto
 * @className: DubboServiceImpl.java
 * @package com.yamhto.producer.impl
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
