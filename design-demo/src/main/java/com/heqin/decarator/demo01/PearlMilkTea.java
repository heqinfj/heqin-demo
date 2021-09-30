package com.heqin.decarator.demo01;

import java.math.BigDecimal;

/**
 * 加珍珠奶茶类
 *
 * @Author heqin
 * @Date 2021/9/29 10:39
 */
public class PearlMilkTea extends MilkTeaDecorator {

    public PearlMilkTea(AbstractMilkTea abstractMilkTea) {
        super(abstractMilkTea);
    }

    @Override
    public String getType() {
        return super.getType() + "+加珍珠";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(BigDecimal.valueOf(5)).setScale(2);
    }
}
