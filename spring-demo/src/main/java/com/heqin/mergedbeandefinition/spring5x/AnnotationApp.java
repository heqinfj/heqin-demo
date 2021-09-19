package com.heqin.mergedbeandefinition.spring5x;

import com.heqin.mergedbeandefinition.spring5x.annotation.TestImportBeanDefiniton;
import com.heqin.mergedbeandefinition.spring5x.beans.DerivedTestBean;
import com.heqin.mergedbeandefinition.spring5x.beans.TestBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The type Annotation app.
 *
 * @Author heqin
 * @Date 2021 /9/13 22:04
 */
@Configuration
@Import({TestImportBeanDefiniton.class})
public class AnnotationApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationApp.class);
        DefaultListableBeanFactory beanFactory = applicationContext.getDefaultListableBeanFactory();
//        System.out.println("Bean定义：");
//        BeanDefinition inheritedTestBeanBd = beanFactory.getMergedBeanDefinition("inheritedTestBean");
//        BeanDefinition inheritsWithDifferentClassBd = beanFactory.getBeanDefinition("inheritsWithDifferentClass");
//        BeanDefinition inheritsWithDifferentClassMbd = beanFactory.getMergedBeanDefinition("inheritsWithDifferentClass");
//        System.out.println("inheritedTestBeanBd: " + inheritedTestBeanBd);
//        System.out.println("inheritsWithDifferentClassBd: " + inheritsWithDifferentClassBd);
//        System.out.println("inheritsWithDifferentClassMbd: " + inheritsWithDifferentClassMbd);


        System.out.println("Bean实例：");
        TestBean testBean = (TestBean)applicationContext.getBean("inheritedTestBean");
        DerivedTestBean derivedTestBean = (DerivedTestBean) applicationContext.getBean("inheritsWithDifferentClass");
        System.out.println("inheritedTestBean: " + testBean);
        System.out.println("inheritsWithDifferentClass: " + derivedTestBean);
    }
}
