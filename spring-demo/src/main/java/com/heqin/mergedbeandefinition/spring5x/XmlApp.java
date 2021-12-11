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
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        if (autowireCapableBeanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) autowireCapableBeanFactory;
            //父类
            BeanDefinition inheritedTestBeanBd = defaultListableBeanFactory.getBeanDefinition("inheritedTestBean");
            BeanDefinition inheritedTestBeanMbd = defaultListableBeanFactory.getMergedBeanDefinition("inheritedTestBean");
            //子类
            BeanDefinition inheritsWithDifferentClassBd = defaultListableBeanFactory.getBeanDefinition("inheritsWithDifferentClass");
            BeanDefinition inheritsWithDifferentClassMbd = defaultListableBeanFactory.getMergedBeanDefinition("inheritsWithDifferentClass");
            System.out.println("Bean定义：");
            System.out.println("    inheritedTestBeanBd:  " + inheritedTestBeanBd);
            System.out.println("    inheritedTestBeanMbd: " + inheritedTestBeanMbd);
            System.out.println("    inheritsWithDifferentClassBd:  " + inheritsWithDifferentClassBd);
            System.out.println("    inheritsWithDifferentClassMbd: " + inheritsWithDifferentClassMbd);
        }

        System.out.println("Bean实例：");
        DerivedTestBean derivedTestBean = (DerivedTestBean) applicationContext.getBean("inheritsWithDifferentClass");
        System.out.println("    子类inheritsWithDifferentClass实例: " + derivedTestBean);

//        TestBean testBean = (DerivedTestBean)applicationContext.getBean("inheritedTestBean");
//        System.out.println(testBean);//Error creating bean with name 'inheritedTestBean': Bean definition is abstract

    }
}
