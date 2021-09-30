package com.heqin.springextension.initPropertySources;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author heqin
 * @Date 2021/9/20 22:05
 */
public class OverrideInitPropertySources extends AnnotationConfigApplicationContext {
    /**
     * 此处做了两个扩展：
     * 第一：向Environment中添加了一个属性值 HOST_NAME；
     * 第二：我们设置了一个必要的系统属性 HOST_IP，当Environment中不包含HOST_IP属性时系统会抛出异常；
     */
    @Override
    protected void initPropertySources() {
        super.initPropertySources();
        ConfigurableEnvironment env = getEnvironment();
        env.getSystemProperties().put("HOST_NAME","XXX");
        env.getSystemEnvironment().put("FORAMT_TYPE","JSON");
        env.setRequiredProperties("HOST_IP");
    }
}
