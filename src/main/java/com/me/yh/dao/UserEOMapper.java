package com.me.yh.dao;

import com.me.utils.base.dao.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserEOMapper extends BaseDao {

    String getUserIdByUserName(@Param("userName") String getUserIdByUserName);

    Set<String> getRoleIdSetByUserId(@Param("userId") String userId);
}