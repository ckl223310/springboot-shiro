package com.me.utils.base.entity;

import java.util.Date;

/**
 * Created by syxy28 on 2018/5/7.
 */
public class ErrorLog {

    /**
     * 声名msg字符串
     */
    private String msg;

    /**
     * 声名类名
     */
    private String className;

    /**
     * 声名创造时间
     */
    private Date createDate;

    public ErrorLog() {
    }

    public ErrorLog(String msg, String className, Date createDate) {
        this.msg = msg;
        this.className = className;
        this.createDate = createDate;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
