package com.heqin.mergedbeandefinition.spring5x;

import com.heqin.mergedbeandefinition.spring5x.beans.DerivedTestBean;
import com.heqin.mergedbeandefinition.spring5x.beans.TestBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author heqin
 * @Date 2021/9/13 20:59
 */
public class XmlApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mergedbeandefinition/BeanDefinitionInheritance.xml");
        DerivedTestBean derivedTestBean = (DerivedTestBean) applicationContext.getBean("inheritsWithDifferentClass");
        System.out.println(derivedTestBean);

//        TestBean testBean = (DerivedTestBean)applicationContext.getBean("inheritedTestBean");
//        System.out.println(testBean);//Error creating bean with name 'inheritedTestBean': Bean definition is abstract
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        if (autowireCapableBeanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) autowireCapableBeanFactory;
            BeanDefinition inheritedTestBean = defaultListableBeanFactory.getBeanDefinition("inheritedTestBean");
            System.out.println(inheritedTestBean);
            BeanDefinition mbd = defaultListableBeanFactory.getMergedBeanDefinition("inheritedTestBean");
            System.out.println(mbd);
        }

    }
}
