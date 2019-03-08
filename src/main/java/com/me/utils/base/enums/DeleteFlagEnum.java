package com.me.utils.base.enums;

/**
 * 逻辑删除枚举
 */
public enum DeleteFlagEnum {
    /**
     * 正常，显示在页面
     */
    NORMAL(1, "正常"),
    /**
     * 已删除，不在页面显示
     */
    DELETE(0, "已删除");

    /**
     * 成员变量，标识
     */
    private int value;
    /**
     * 成员变量，标识代表的含义
     */
    private String label;

    DeleteFlagEnum(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

}
