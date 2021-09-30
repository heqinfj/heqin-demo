package com.heqin.strategy.demo01;

import java.math.BigDecimal;

/**
 * 满减折扣策略
 *
 * @Author heqin
 * @Date 2021/9/29 20:20
 */
public class OverDiscountStrategy implements DiscountStrategy {
    /**
     * 满100减20
     *
     * @param total
     * @return
     */
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.compareTo(BigDecimal.valueOf(100)) >= 0 ? BigDecimal.valueOf(20) : BigDecimal.ZERO;
    }
}
