package com.me.utils.base.entity;

import java.util.Date;

/**
 * @Author: syxy28
 * @Date: Created in 15:39 2018/4/20
 */
public class BusinessLog {

    /**
     * 模块名称
     **/
    private String moduleName;

    /**
     * 记录内容
     **/
    private String content;

    /**
     * 创建人
     **/
    private String operator;

    /**
     * 操作时间
     **/
    private Date optTime;

    public BusinessLog() {
    }

    public BusinessLog(String moduleName, String content, String operator, Date optTime) {
        this.moduleName = moduleName;
        this.content = content;
        this.operator = operator;
        this.optTime = optTime;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
