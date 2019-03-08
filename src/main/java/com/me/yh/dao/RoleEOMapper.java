package com.me.yh.dao;

import com.me.utils.base.dao.BaseDao;
import com.me.yh.entity.RoleEO;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleEOMapper extends BaseDao<RoleEO> {

    Set<RoleEO> getRoleSetByRoleIds(Set<String> roleIdSet);
}