package com.me.yh.dao;

import com.me.yh.entity.RoleEO;

public interface RoleEOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleEO record);

    int insertSelective(RoleEO record);

    RoleEO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleEO record);

    int updateByPrimaryKey(RoleEO record);
}