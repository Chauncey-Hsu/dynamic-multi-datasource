package com.warm.system.util;

import java.text.NumberFormat;

/**
 * @author xuchuanqi
 * @date 2022/2/23 20:26.
 */
public class NumUtil {

    public static Double formatNum(double d, int bit) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(bit);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
//        nf.setRoundingMode(RoundingMode.UP);
        return Double.valueOf(nf.format(d));
    }

    public static void main(String[] args) {
        System.out.println(formatNum(1.645646D, 2));
    }
}
