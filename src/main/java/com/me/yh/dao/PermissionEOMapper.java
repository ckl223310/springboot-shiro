package com.me.yh.dao;

import com.me.yh.entity.PermissionEO;

public interface PermissionEOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionEO record);

    int insertSelective(PermissionEO record);

    PermissionEO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionEO record);

    int updateByPrimaryKey(PermissionEO record);
}