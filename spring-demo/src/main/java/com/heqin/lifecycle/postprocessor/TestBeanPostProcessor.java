package com.heqin.lifecycle.postprocessor;

import com.heqin.lifecycle.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author heqin
 */
public class TestBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println(String.format("%s的方法 postProcessBeforeInitialization...", this.getClass().getName()));
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println(String.format("%s的方法 postProcessAfterInitialization...", this.getClass().getName()));
        }
        return bean;
    }
}
