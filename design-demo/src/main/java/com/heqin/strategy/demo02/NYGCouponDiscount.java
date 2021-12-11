package com.heqin.strategy.demo02;

import java.math.BigDecimal;

/**
 * @Author heqin
 * @Date 2021/9/30 21:40
 */
public class NYGCouponDiscount implements ICouponDiscount<Double>{
    /**
     *  n元购购买
     *  无论原价多少钱都固定金额购买
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo).setScale(2);
    }
}
