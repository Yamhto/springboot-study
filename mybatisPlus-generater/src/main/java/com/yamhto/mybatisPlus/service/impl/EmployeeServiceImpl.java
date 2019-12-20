package com.yamhto.mybatisPlus.service.impl;

import com.yamhto.mybatisPlus.entity.Employee;
import com.yamhto.mybatisPlus.mapper.EmployeeMapper;
import com.yamhto.mybatisPlus.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yamhto
 * @since 2019-12-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
