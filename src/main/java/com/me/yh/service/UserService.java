package com.me.yh.service;

import com.me.utils.base.dao.BaseDao;
import com.me.utils.base.exception.SystemBaseException;
import com.me.utils.base.service.AbstractBaseService;
import com.me.yh.dao.RoleEOMapper;
import com.me.yh.dao.UserEOMapper;
import com.me.yh.entity.RoleEO;
import com.me.yh.entity.UserEO;
import com.me.yh.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

/**
 * 添加类/接口功能描述
 *
 * @author czh
 * date 2019-03-08
 */
@Service
@Transactional
public class UserService extends AbstractBaseService<UserEO, String> {

    /**
     * userEOMapper
     */
    @Autowired
    private UserEOMapper userEOMapper;

    @Autowired
    private RoleEOMapper roleEOMapper;


    /**
     * 新增用户
     * @param userVO
     */
    public void insertUser(@RequestBody UserVO userVO) {

        if (userVO == null) {
            throw new SystemBaseException("传参不能为空");
        }

        String userName = userVO.getUserName();
        if (StringUtils.isBlank(userName)) {
            throw new SystemBaseException("用户名不能为空");
        }
        userName = userName.trim();

        String password = userVO.getPassword();
        if (StringUtils.isBlank(password)) {
            throw new SystemBaseException("用户名密码不能为空");
        }
        password = userName.trim();

        UserEO userEO = new UserEO();
        try {
            userEOMapper.insert(userEO);
        } catch (Exception e) {
            throw new SystemBaseException(e.getMessage());
        }
    }

    public Set<RoleEO> getRoleIdSetByUserId(String userId) {
        try {

            if (StringUtils.isBlank(userId)) {
                throw new SystemBaseException("用户ID不能为空");
            }
            userId = userId.trim();

            try {
                Set<String> roleIdSet = userEOMapper.getRoleIdSetByUserId(userId);
                if (CollectionUtils.isEmpty(roleIdSet)) {
                    return new HashSet<>();
                }

                return roleEOMapper.getRoleSetByRoleIds(roleIdSet);
            } catch (Exception e) {
                throw new SystemBaseException(e.getMessage());
            }

        } catch (Exception e) {
            throw new SystemBaseException(e.getMessage());
        }
    }

    /**
     * 根据用户名获取用户Id
     * @param userName
     * @return
     */
    public String getUserIdByUserName(@RequestParam("userName") String userName) {

        try {
            return userEOMapper.getUserIdByUserName(userName);
        } catch (Exception e) {
           throw new SystemBaseException(e.getMessage());
        }
    }

    @Override
    public BaseDao<UserEO> getDao() {
        return userEOMapper;
    }
}
