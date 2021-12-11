package com.heqin.strategy.demo02;

import java.math.BigDecimal;

/**
 * 策略控制类
 *
 * @Author heqin
 * @Date 2021/9/30 14:53
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

}
