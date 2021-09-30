package com.heqin.decarator.demo01;

import java.math.BigDecimal;

/**
 * 通用的奶茶类，抽象奶茶类的具体子类
 *
 * @Author heqin
 * @Date 2021/9/29 10:16
 */
public class GenericMilkTea extends AbstractMilkTea {
    @Override
    public String getType() {
        return "奶茶";
    }

    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(13);
    }
}
