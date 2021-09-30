package com.heqin.decarator.demo01;

import java.math.BigDecimal;

/**
 * 加冰的奶茶类
 *
 * @Author heqin
 * @Date 2021/9/29 10:21
 */
public class IceMilkTea extends MilkTeaDecorator {

    public IceMilkTea(AbstractMilkTea abstractMilkTea) {
        super(abstractMilkTea);
    }

    @Override
    public String getType() {
        return super.getType() + "+加冰";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(BigDecimal.valueOf(3)).setScale(2);
    }
}
