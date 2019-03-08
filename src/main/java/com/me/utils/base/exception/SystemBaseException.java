package com.me.utils.base.exception;
import com.me.utils.http.CodeEnum;

import java.io.Serializable;

/**
 * 自定义异常类
 *
 * @return date 2018/8/28
 **/
public class SystemBaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -3785352450518033758L;

    /**
     * 异常返回代码
     **/
    private String errorCode;

    public SystemBaseException() {
    }

    public SystemBaseException(String message) {
        this("-1", message);
    }

    public SystemBaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public SystemBaseException(CodeEnum codeEnum) {
        this(codeEnum.getCode(), codeEnum.getMsg());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
