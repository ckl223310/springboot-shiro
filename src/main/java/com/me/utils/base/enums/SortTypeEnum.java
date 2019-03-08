package com.me.utils.base.enums;

/**
 * 正序倒序枚举类
 *
 * @author czh
 * date 2018-12-02
 **/
public enum SortTypeEnum {
    /**
     * 正序
     */
    ASC(1, "正序"),
    /**
     * 倒序
     */
    DESC(2, "倒序");

    /**
     * 成员变量，审核结果代码
     */
    private int shortValue;

    /**
     * 成员变量，审核结果代码代表的含义
     */
    private String shortLabel;


    SortTypeEnum(int shortValue, String shortLabel) {
        this.shortValue = shortValue;
        this.shortLabel = shortLabel;
    }

    public int getValue() {
        return shortValue;
    }

    public String getShortLabel() {
        return shortLabel;
    }
}
