package com.warm.system.util;

import java.util.Random;

/**
 * @author xuchuanqi
 * @date 2022/2/23 20:17.
 */
public class GaussianUtil {

    /**
     * @param ave 平均值、期望
     * @param var 方差
     * @return 符合正态分布的随机数
     */
    public static double getGaussian(int avg, int var){
        Random random = new Random();
        double num = Math.sqrt(var) * random.nextGaussian() + avg;
        return num;

    }
}
