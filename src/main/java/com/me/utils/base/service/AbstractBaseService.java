package com.me.utils.base.service;


import com.me.utils.base.dao.BaseDao;
import com.me.utils.base.entity.BaseEntity;
import com.me.utils.http.PageInfo;

import java.util.List;

/**
 * 公共方法service层
 *
 * @author czh
 * date 2019/3/28
 **/
public abstract class AbstractBaseService<T extends BaseEntity, K> {

    /**
     * 注入dao层
     * @author czh
     * date 2019/3/28
     * @return
     **/
    public abstract BaseDao<T> getDao();

    /**
     * 插入/新增数据
     *
     * @param t
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public Integer insert(T t) throws Exception {
        return getDao().insert(t);
    }

    /**
     * 选择性插入数据
     *
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public int insertSelective(T t) throws Exception {
        return getDao().insertSelective(t);
    }

    /**
     * 根据主键进行修改
     *
     * @param t
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public int updateByPrimaryKey(T t) throws Exception {
        return getDao().updateByPrimaryKey(t);
    }

    /**
     * 根据其他信息进行修改
     *
     * @param t
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public int updateByPrimaryKeySelective(T t) throws Exception {
        return getDao().updateByPrimaryKeySelective(t);
    }

    /**
     * 根据主键进行查询
     *
     * @param value
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public T selectByPrimaryKey(K value) throws Exception {
        return getDao().selectByPrimaryKey(value);
    }

    /**
     * 根据主键进行删除
     *
     * @param value
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public void deleteByPrimaryKey(K value) throws Exception {
        getDao().deleteByPrimaryKey(value);
    }

    /**
     * 查询列表信息
     *
     * @param pageInfo
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public List<T> queryByList(PageInfo pageInfo) throws Exception {
        return getDao().queryByList(pageInfo);
    }

    /**
     * 查询总数量
     *
     * @param pageInfo
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public Long queryByCount(PageInfo pageInfo) throws Exception {
        return getDao().queryByCount(pageInfo);
    }

    /**
     * 查询单条信息
     *
     * @param pageInfo
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public T queryBySingle(PageInfo pageInfo) throws Exception {
        pageInfo.setPageSize(1);
        List<T> results = getDao().queryByList(pageInfo);
        return null == results || results.size() == 0 ? null : results.get(0);
    }

    /**
     * 分页查询
     *
     * @param pageInfo
     * @return
     * @author czh
     * date 2019/3/28
     **/
    public PageInfo<T> queryByPage(PageInfo pageInfo) throws Exception {
        pageInfo.setStartIndex(((pageInfo.getPageNo() - 1) * pageInfo.getPageSize() + 1));
        pageInfo.setEndIndex(pageInfo.getPageNo() * pageInfo.getPageSize());

        Long count = queryByCount(pageInfo);
        List<T> result = getDao().queryByPage(pageInfo);

        PageInfo<T> returnPage = new PageInfo<>();
        returnPage.setCount(count);
        returnPage.setList(result);
        returnPage.setPageCount(count % pageInfo.getPageSize() == 0
                ? count / pageInfo.getPageSize() : count / pageInfo.getPageSize() + 1);
        returnPage.setPageNo(pageInfo.getPageNo());
        returnPage.setPageSize(pageInfo.getPageSize());
        return returnPage;
    }
}
