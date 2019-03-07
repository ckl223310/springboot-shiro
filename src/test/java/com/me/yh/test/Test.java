package com.me.yh.test;

/**
 * //TODO 添加类/接口功能描述 * * @author 作者信息 * @date 2019-03-07
 */
public class Test {



    public static int fibonacci(int value) {

        if (value == 0 || value == 1) {
            return 1;
        }

        return fibonacci (value - 1) + fibonacci(value -2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(11));
        System.out.println(fibonacci(12));
    }
}
