package com.heqin.strategy.demo01;

import java.math.BigDecimal;

/**
 * 测试类
 *
 * @Author heqin
 * @Date 2021/9/29 20:34
 */
public class ApiTest {
    public static void main(String[] args) {
        DiscountContext ctx = new DiscountContext();
        // 默认使用普通会员折扣:
        BigDecimal pay1 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay1);

        // 使用满减折扣:
        ctx.setDiscountStrategy(new OverDiscountStrategy());
        BigDecimal pay2 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay2);

        // 使用Prime会员折扣:
        ctx.setDiscountStrategy(new PrimeDiscountStrategy());
        BigDecimal pay3 = ctx.calculatePrice(BigDecimal.valueOf(105));
        System.out.println(pay3);
    }
}
