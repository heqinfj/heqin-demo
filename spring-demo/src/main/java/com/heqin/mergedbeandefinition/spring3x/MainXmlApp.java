package com.heqin.mergedbeandefinition.spring3x;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * xml 启动
 *
 * @Author heqin
 * @Date 2021/9/13 16:28
 */
@Configuration
@ImportResource(value = {"classpath:mergedbeandefinition/applicationContext.xml"})
public class MainXmlApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainXmlApp.class);
        DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();

        //父类
        BeanDefinition parentBd = beanFactory.getBeanDefinition("parent");
        BeanDefinition parentMbd = beanFactory.getMergedBeanDefinition("parent");
        //子类
        BeanDefinition childBd = beanFactory.getBeanDefinition("child");
        BeanDefinition childMdb = beanFactory.getMergedBeanDefinition("child");
        Object adminEmails = childMdb.getPropertyValues().get("adminEmails");
        System.out.println("Bean定义：");
        System.out.println("    parentBd:   " + parentBd);
        System.out.println("    parentMbd:  " + parentMbd);
        System.out.println("    childBd:    " + childBd);
        System.out.println("    childMdb:   " + childMdb);

        System.out.println("Bean实例：");
        ComplexObject childBean = (ComplexObject)beanFactory.getBean("child");
        System.out.println("    childBean:  " + childBean);
    }
}
