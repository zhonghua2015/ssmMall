package com.mall.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by eid on 2017/12/7.
 */
public class BigDecimalUtil {
    private BigDecimalUtil(){}

    public static BigDecimal add(double value1, double value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2);
    }

    public static BigDecimal subtract(double value1, double value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2);
    }

    public static BigDecimal multiply(double value1, double value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2);
    }

    public static BigDecimal divide(double value1, double value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, 2, RoundingMode.HALF_UP);  //四舍五入,保留2位小数
    }



}
