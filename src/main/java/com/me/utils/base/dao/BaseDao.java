package com.me.utils.base.dao;

import com.me.utils.base.entity.BaseEntity;
import com.me.utils.http.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 共用方法dao层
 *
 * @author czh
 * date 2019/3/28
 **/
public interface BaseDao<T extends BaseEntity> {
    /**
     * 插入/新增数据
     *
     * @param record
     * @return
     * @author czh
     * date 2019/3/28
     **/
    int insert(T record);

    /**
     * 选择性插入数据
     *
     * @return
     * @author czh
     * date 2019/3/28
     **/
    int insertSelective(T record);

    /**
     * 根据主键进行删除
     *
     * @param id
     * @return
     * @author czh
     * date 2019/3/28
     **/
    int deleteByPrimaryKey(Object id);

    /**
     * 根据主键进行修改
     *
     * @param record
     * @return
     * @author czh
     * date 2019/3/28
     **/
    int updateByPrimaryKey(T record);

    /**
     * 根据其他信息进行修改
     *
     * @param record
     * @return
     * @author czh
     * date 2019/3/28
     **/
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键进行查询
     *
     * @param id
     * @return
     * @author czh
     * date 2019/3/28
     **/
    T selectByPrimaryKey(Object id);

    /**
     * 查询列表信息
     *
     * @param pageInfo
     * @return
     * @author czh
     * date 2019/3/28
     **/
    List<T> queryByList(PageInfo<T> pageInfo);

    /**
     * 查询总数量
     *
     * @param pageInfo
     * @return
     * @author czh
     * date 2019/3/28
     **/
    Long queryByCount(PageInfo<T> pageInfo);

    /**
     * 分页查询
     *
     * @param pageInfo
     * @return
     * @author czh
     * date 2019/3/28
     **/
    List<T> queryByPage(PageInfo<T> pageInfo);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     * @author czh
     * date 2019/3/28
     **/
    int deleteLogicInBatch(@Param("ids") List<String> ids);
}
