package com.heqin.strategy.demo01;

import java.math.BigDecimal;

/**
 * 使用策略的上下文
 *
 * @Author heqin
 * @Date 2021/9/29 20:35
 */
public class DiscountContext {

    //持有某个策略，默认普通会员打折策略
    private DiscountStrategy discountStrategy = new UserDiscountStrategy();

    //允许客户端设置策略
    public void setDiscountStrategy(DiscountStrategy discountStrategy){
        this.discountStrategy = discountStrategy;
    }

    public BigDecimal calculatePrice(BigDecimal total){
        return total.subtract(discountStrategy.getDiscount(total)).setScale(2);
    }
}
