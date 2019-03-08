package com.me.utils.base.entity;

import com.me.utils.base.enums.DeleteFlagEnum;

import java.util.Date;

/**
 * 共用实体
 *
 * @author czh
 * date 2019/3/28
 **/
public class BaseEntity {

    /**
     * 创建日期
     **/
    private Date createDate = new Date();

    /**
     * 删除标记，默认未删除
     **/
    private Integer del = DeleteFlagEnum.NORMAL.getValue();

    /**
     * 创建人，默认当前用户
     **/
    private String createBy;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

}
