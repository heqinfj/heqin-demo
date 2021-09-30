package com.heqin.decarator.demo01;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 奶茶装饰器
 *
 * @Author heqin
 * @Date 2021/9/29 10:19
 */
public abstract class MilkTeaDecorator extends AbstractMilkTea{

    private AbstractMilkTea abstractMilkTea;

    public MilkTeaDecorator(AbstractMilkTea abstractMilkTea) {
        this.abstractMilkTea = abstractMilkTea;
    }

    @Override
    public String getType() {
        return abstractMilkTea.getType();
    }

    @Override
    public BigDecimal getPrice() {
        return abstractMilkTea.getPrice();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("类型", getType())
                .append("价格", getPrice())
                .toString();
    }
}
