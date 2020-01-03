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
public class TPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 权限名
     */
    private String permissionname;

    /**
     * 外键关联role
     */
    private Integer roleId;


}
