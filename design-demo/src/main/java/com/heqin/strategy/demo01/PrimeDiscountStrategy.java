package com.heqin.strategy.demo01;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 打7折策略
 *
 * @Author heqin
 * @Date 2021/9/29 20:30
 */
public class PrimeDiscountStrategy implements DiscountStrategy {

    /**
     * prime会员打7折
     *
     * @param total
     * @return
     */
    @Override
    public BigDecimal getDiscount(BigDecimal total) {
        return total.multiply(BigDecimal.valueOf(0.3)).setScale(2, RoundingMode.DOWN);
    }
}
