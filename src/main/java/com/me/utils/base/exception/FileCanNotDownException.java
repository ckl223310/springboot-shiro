package com.me.utils.base.exception;

import java.io.IOException;

/**
 * 文件不能下载异常类
 */
public class FileCanNotDownException extends IOException {

    private static final long serialVersionUID = 82740269887279277L;

    /**
     * 声名code
     */
    private String code;

    public FileCanNotDownException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
