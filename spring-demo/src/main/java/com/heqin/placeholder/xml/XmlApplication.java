package com.heqin.placeholder.xml;

import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author heqin
 * @Date 2021/9/12 6:14
 */
public class XmlApplication {

    @Test
    public void testA() {
        commonMethod();
    }

    private static void commonMethod() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("placeholder/bean.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName -> System.out.println(beanDefinitionName));

//        PropertyPlaceholderConfigurer ph1 = (PropertyPlaceholderConfigurer)applicationContext.getBean("ph1");
//        PropertyPlaceholderConfigurer ph2 = (PropertyPlaceholderConfigurer)applicationContext.getBean("ph2");

        DataSource dataSource = (DataSource) applicationContext.getBean("com.heqin.placeholder.xml.DataSource#0");
        System.out.println(dataSource);

    }
}
