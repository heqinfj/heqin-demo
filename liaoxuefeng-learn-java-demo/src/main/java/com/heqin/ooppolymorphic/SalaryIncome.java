package com.heqin.ooppolymorphic;

/**
 * 工资收入
 *
 * @Author heqin
 * @Date 2021/10/1 23:10
 */
public class SalaryIncome extends Income {

    public SalaryIncome(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}
