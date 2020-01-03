package com.yamhto.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamhto.shiro.bean.TUser;
import com.yamhto.shiro.mapper.TUserMapper;
import com.yamhto.shiro.service.TUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yamhto
 * @since 2019-12-25
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
