package com.yamhto.shiro.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yamhto.shiro.bean.TPermission;
import com.yamhto.shiro.bean.TRole;
import com.yamhto.shiro.bean.TUser;
import com.yamhto.shiro.service.RoleService;
import com.yamhto.shiro.service.TPermissionService;
import com.yamhto.shiro.service.TUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yamhto
 * @className: Realm.java
 * @package com.yamhto.shiro.config
 * @description:
 * @date 2019/12/25 18:42
 */
public class Realm extends AuthorizingRealm {

    @Autowired
    private TUserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TPermissionService permissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        QueryWrapper<TUser> queryUWrapper = new QueryWrapper<>();
        queryUWrapper.lambda().eq(TUser::getUsername, username);
        TUser user = userService.getOne(queryUWrapper);

        QueryWrapper<TRole> queryRWrapper = new QueryWrapper<>();
        queryRWrapper.lambda().eq(TRole::getId, user.getRoleId());
        List<TRole> rList = roleService.list(queryRWrapper);
        Set<String> roles = new HashSet<>();

        rList.forEach(role -> roles.add(role.getId() + ""));

        // 给该用户设置角色，角色信息存在 t_role 表中取
        authorizationInfo.setRoles(roles);

        Set<String> permissions = new HashSet<>();

        rList.forEach(role -> {
            QueryWrapper<TPermission> queryPWrapper = new QueryWrapper<>();
            queryPWrapper.lambda().eq(TPermission::getRoleId, role.getId());
            List<TPermission> pList = permissionService.list(queryPWrapper);

            pList.forEach(permission -> permissions.add(permission.getId() + ""));
        });

        // 给该用户设置权限，权限信息存在 t_permission 表中取
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 根据 Token 获取用户名，如果您不知道该 Token 怎么来的，先可以不管，下文会解释
        String username = (String) authenticationToken.getPrincipal();
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TUser::getUsername, username);
        // 根据用户名从数据库中查询该用户
        TUser user = userService.getOne(queryWrapper);
        if (user != null) {
            // 把当前用户存到 Session 中
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            // 传入用户名和密码进行身份认证，并返回认证信息
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "myRealm");
            return authcInfo;
        } else {
            return null;
        }
    }
}
