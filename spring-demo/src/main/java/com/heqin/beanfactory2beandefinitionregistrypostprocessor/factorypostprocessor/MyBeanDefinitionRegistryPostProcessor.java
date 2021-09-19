package com.heqin.beanfactory2beandefinitionregistrypostprocessor.factorypostprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author heqin
 * @Date 2021/9/7 6:57
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MyBeanDefinitionRegistryPostProcessor.class);

    public MyBeanDefinitionRegistryPostProcessor(){
        logger.info("实例化MyBeanDefinitionRegistryPostProcessor Bean");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int beanDefinitionCount = registry.getBeanDefinitionCount();
        logger.info("Bean定义个数: " + beanDefinitionCount);
        // 添加一个新的Bean定义
        RootBeanDefinition definition = new RootBeanDefinition(Object.class);
        registry.registerBeanDefinition("hello", definition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
