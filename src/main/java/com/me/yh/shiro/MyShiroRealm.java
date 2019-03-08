package com.me.yh.shiro;

import com.me.yh.entity.RoleEO;
import com.me.yh.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 添加类/接口功能描述
 *
 * @author czh
 * date 2019-03-08
 */
public class MyShiroRealm extends AuthorizingRealm {

    /**
     * userService
     */
    @Autowired
    private UserService userService;

    /**
     * 提供用户信息，返回权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();

        String userName = (String) principalCollection.getPrimaryPrincipal();

        String userId = userService.getUserIdByUserName(userName);

        Set<RoleEO> roleEOSet = userService.getRoleIdSetByUserId(userId);
        Set<String> roleIdSet = new HashSet<>();

        Set<Integer> permissionIdSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();

        authenticationInfo.setRoles(roleIdSet);
        authenticationInfo.setStringPermissions(permissionSet);

        return authenticationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
