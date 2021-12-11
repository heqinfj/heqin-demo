package com.heqin.ooppolymorphic;

/**
 * 稿费收入税率是20%
 *
 * @Author heqin
 * @Date 2021/10/1 23:10
 */
public class RoyaltyIncome extends Income{

    public RoyaltyIncome(double income) {
        super(income);
    }

    // TODO
    @Override
    public double getTax() {
        return income * 0.2;
    }
}
