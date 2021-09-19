package com.heqin.beanfactory2beandefinitionregistrypostprocessor.factorypostprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author heqin
 * @Date 2021/9/7 6:40
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MyBeanFactoryPostProcessor.class);

    public MyBeanFactoryPostProcessor() {
        logger.info("实例化MyBeanFactoryPostProcessor Bean");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        logger.info("bean定义的个数：{}", beanDefinitionCount);
    }

    @Component
    class TestBean {
        public TestBean() {
            logger.info("实例化TestBean Bean");
        }
    }
}
