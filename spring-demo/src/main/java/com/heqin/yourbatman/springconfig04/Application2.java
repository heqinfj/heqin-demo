package com.heqin.yourbatman.springconfig04;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class Application2 {
    public static void main(String[] args) throws IllegalAccessException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = context.getBean(AppConfig.class);
        Field $$beanFactoryField = ReflectionUtils.findField(appConfig.getClass(), "$$beanFactory");
        BeanFactory beanFactory = (BeanFactory) $$beanFactoryField.get(appConfig);
        System.out.println(beanFactory == context.getAutowireCapableBeanFactory());
        System.out.println(beanFactory == context);
        System.out.println(appConfig instanceof BeanFactoryAware);
        System.out.println(appConfig.getClass().getInterfaces()[0]);
    }
}