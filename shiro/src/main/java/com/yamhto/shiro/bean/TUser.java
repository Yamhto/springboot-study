package com.yamhto.shiro.bean;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yamhto
 * @since 2019-12-25
 */
@Setter
@Getter
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 外键关联role表
     */
    private Integer roleId;


}
