package com.heqin.mergedbeandefinition.spring3x;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author heqin
 * @Date 2021/9/13 16:44
 */
@Configuration
@Import({CustomerComplexObjectBeanDefinition.class})
public class MainAnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainAnnotationApp.class);
        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
        BeanDefinition mbd = beanFactory.getMergedBeanDefinition("child");
        System.out.println("mdb: " + mbd);
        BeanDefinition bd = beanFactory.getBeanDefinition("child");
        System.out.println("bd: " + bd);

        System.out.println("=======================================================");
        ComplexObject child = (ComplexObject)beanFactory.getBean("child");
        System.out.println(child);
    }
}
