package com.heqin.ooppolymorphic;

/**
 * 收入。
 *
 * @Author heqin
 * @Date 2021/10/1 23:07
 */
public class Income {

    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }

}
