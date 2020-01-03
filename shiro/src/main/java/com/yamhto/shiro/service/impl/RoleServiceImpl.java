package com.yamhto.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamhto.shiro.bean.TRole;
import com.yamhto.shiro.mapper.RoleMapper;
import com.yamhto.shiro.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, TRole> implements RoleService {

}
