package com.heqin.strategy.demo01;

import java.math.BigDecimal;

/**
 * 打折策略接口
 *
 * @Author heqin
 * @Date 2021/9/29 20:11
 */
public interface DiscountStrategy {
    /**
     * 计算折扣额度
     * @param total
     * @return
     */
    BigDecimal getDiscount(BigDecimal total);
}
