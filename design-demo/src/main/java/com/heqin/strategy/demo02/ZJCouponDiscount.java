package com.heqin.strategy.demo02;

import java.math.BigDecimal;

/**
 * @Author heqin
 * @Date 2021/9/30 21:36
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使用商品价格减去优惠价格
     * 2. 最低支付金额1元
     *
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal price = skuPrice.subtract(BigDecimal.valueOf(couponInfo)).setScale(2);;
        if (price.compareTo(BigDecimal.ONE) <= 0) {
            return BigDecimal.ONE.setScale(2);
        }
        return price;
    }
}
