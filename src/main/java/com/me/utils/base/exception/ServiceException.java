package com.me.utils.base.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 自定义异常
 * Created by Youdmeng on 2018/5/08 0028.
 */
public class ServiceException extends RuntimeException {
    /**
     * 错误代码
     */
    private Integer errCode;

    /**
     * 错误数据
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private transient Object errData;

    public ServiceException(Integer errCode, String message, Object errData, Throwable throwable) {
        super(message, throwable);
        this.errCode = errCode;
        this.errData = errData;
    }

    public ServiceException(Integer errCode, Object errData, String message) {
        super(message);
        this.errCode = errCode;
        this.errData = errData;
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Gets the value of errCode.
     *
     * @return the value of errCode
     */
    public Integer getErrCode() {
        return errCode;
    }

    /**
     * Gets the value of errData.
     *
     * @return the value of errData
     */
    public Object getErrData() {
        return errData;
    }
}
