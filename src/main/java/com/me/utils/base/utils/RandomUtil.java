package com.me.utils.base.utils;


import org.apache.commons.lang3.RandomUtils;

import java.awt.*;
import java.util.Random;

/**
 * 随机数类
 */
public class RandomUtil extends RandomUtils {

    /**
     * codeSeq
     */
    private static final char[] CODESEQ = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
        'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
        'X', 'Y', 'Z'};
    /**
     * numberArray
     */
    private static final char[] NUMBERARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    /**
     * Random
     */
    private static Random random = new Random();

    /**
     * 返回随机的字符串
     * @param length
     * @return
     */
    public static final String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                sb.append(String.valueOf(CODESEQ[random.nextInt(CODESEQ.length)]));
            } else {
                sb.append(String.valueOf(NUMBERARRAY[random.nextInt(NUMBERARRAY.length)]));
            }
        }
        return sb.toString();
    }

    /**
     * 返回随机的字符串
     * @param length
     * @return
     */
    public static final String randomCharString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(CODESEQ[random.nextInt(CODESEQ.length)]));
        }
        return sb.toString();
    }

    /**
     * 返回随机数字符串
     * @param length
     * @return
     */
    public static final String randomNumberString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(NUMBERARRAY[random.nextInt(NUMBERARRAY.length)]));
        }
        return sb.toString();
    }

    /**
     * 返回随机颜色
     * @param fc
     * @param bc
     * @return
     */
    public static Color randomColor(int fc, int bc) {
        int f = fc;
        int b = bc;
        Random random = new Random();
        if (f > 255) {
            f = 255;
        }
        if (b > 255) {
            b = 255;
        }
        return new Color(f + random.nextInt(b - f), f + random.nextInt(b - f), f + random.nextInt(b - f));
    }

    /**
     * 返回int随机数
     * @param bound
     * @return
     */
    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
