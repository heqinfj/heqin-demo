package com.heqin.yourbatman.springconfig03.spring.bean;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author heqin
 */
@Order(Ordered.LOWEST_PRECEDENCE)
@Component
public class FirstPerson {
    public FirstPerson(){
        System.out.println(String.format("线程：%s触发调用构造函数：%s",Thread.currentThread().getName(),this.getClass().getName()));
    }
}
