package com.me.utils.http;

/**
 * 校验错误实体
 * date 2018/8/28
 **/
public class ValidError {

    /**
     * 字段
     **/
    private String field;
    /**
     * 信息
     **/
    private String message;

    public ValidError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
