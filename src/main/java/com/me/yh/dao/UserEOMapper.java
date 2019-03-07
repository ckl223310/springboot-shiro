package com.me.yh.dao;

import com.me.yh.entity.UserEO;

public interface UserEOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEO record);

    int insertSelective(UserEO record);

    UserEO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEO record);

    int updateByPrimaryKey(UserEO record);
}