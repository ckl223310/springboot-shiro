package com.me.utils.http;

/**
 * 响应码枚举类
 */
public enum CodeEnum {
    /**
     * 系统错误
     */
    ERROR("-1", "系统错误"),
    /**
     * 操作成功"
     */
    SUCCESS("0", "操作成功"),
    /**
     * 操作失败"
     */
    NOT_SUCCESS("1", "操作失败"),

    /**
     * 校验失败"
     */
    VALID_ERROR("1000", "校验失败"),

    /**
     * 不合法消息类型
     */
    ILLEGAL_MESSAGE_TYPE("1006", "不合法消息类型"),

    /**
     * 不合法的参数
     */
    ILLEGAL_PARAM("1010", "不合法的参数"),

    /**
     * 登录会话过期,请重新登陆
     */
    LOGIN_TIMEOUT("1085", "登录会话过期,请重新登陆！！！");

    /**
     * code码
     */
    private String code;
    /**
     * 对应的消息
     */
    private String msg;

    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
