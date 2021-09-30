package com.heqin.strategy.demo01;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 普通会员折扣策略
 *
 * @Author heqin
 * @Date 2021/9/29 20:14
 */
public class UserDiscountStrategy implements DiscountStrategy {
    /**
     * 普通会员打9折
     */
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.multiply(new BigDecimal(0.1)).setScale(2, RoundingMode.DOWN);
    }
}
