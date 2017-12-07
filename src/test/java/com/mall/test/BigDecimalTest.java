package com.mall.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by eid on 2017/12/7.
 */
public class BigDecimalTest {

    @Test
    public void test1(){
        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.43);
        System.out.println(2.382 * 100);
        System.out.println(113.4/100);
    }

    @Test
    public void test2(){
        BigDecimal b1 = new BigDecimal(0.05);
        BigDecimal b2 = new BigDecimal(0.01);
        System.out.println(b1.add(b2));
    }

    @Test
    public void test3(){
        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println(b1.add(b2));
    }
}
