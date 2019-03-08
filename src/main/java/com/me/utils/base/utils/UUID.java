package com.me.utils.base.utils;

/**
 * 生成主键工具类
 **/
public final class UUID {

    /**
     * 生成随机数
     **/
    public static String randomUUID10() {
        return RandomUtil.randomString(10);
    }

    /**
    * 生成随机数（主键32位）
    **/
    public static String randomUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }
    /**
     * 生成随机数
     **/
    public static String randomUUID(int length) {
        String uuId = randomUUID();
        if (length > uuId.length()) {
            length = uuId.length();
        }
        return uuId.substring(0, length);
    }
    /**
     * 生成随机数
     **/
    public static String randomUserId() {
        return RandomUtil.randomNumberString(10);
    }
    /**
     * 生成随机数
     **/
    public static String createToken() {
        return randomUUID() + java.util.UUID.randomUUID();
    }
}
