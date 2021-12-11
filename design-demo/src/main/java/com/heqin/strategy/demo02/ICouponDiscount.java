package com.heqin.strategy.demo02;

import java.math.BigDecimal;

/**
 * 优惠券接口
 *
 * @Author heqin
 * @Date 2021/9/30 14:50
 */
public interface ICouponDiscount<T> {

    /**
     * 优惠券金额计算，返回优惠后的金额
     *
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return 优惠后的金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
