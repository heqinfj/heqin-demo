package com.heqin.decarator.demo01;

import java.math.BigDecimal;

/**
 * 抽象奶茶类
 *
 * @Author heqin
 * @Date 2021/9/29 10:11
 */
public abstract class AbstractMilkTea {

    /**
     * 奶茶类型
     * @return
     */
    public abstract String getType();

    /**
     * 奶茶价格
     * @return
     */
    public abstract BigDecimal getPrice();
}
