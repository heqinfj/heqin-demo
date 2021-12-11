package com.heqin.flyweightpatterninspring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author heqin
 * @Date 2021/10/26 10:34
 */
public class App {

    ClassPathXmlApplicationContext applicationContext = null;

    @Before
    public void initialize() {
        applicationContext = new ClassPathXmlApplicationContext("flyweightpatterninspring/bean.xml");

    }

    @Test
    public void testSingletonReferencePrototypeError() {
        SingletonReferencePrototype singletonReferencePrototype = (SingletonReferencePrototype) applicationContext.getBean("singletonReferencePrototypeError");
        System.out.println(singletonReferencePrototype.getMyTestBean() == singletonReferencePrototype.getMyTestBean());
        System.out.println(singletonReferencePrototype.getMyTestBean());
        System.out.println(singletonReferencePrototype.getMyTestBean());
    }

    @Test
    public void testSingletonReferencePrototypeRight() {
        SingletonReferencePrototype singletonReferencePrototype = (SingletonReferencePrototype) applicationContext.getBean("singletonReferencePrototypeRight");
        System.out.println(singletonReferencePrototype.getMyTestBean() == singletonReferencePrototype.getMyTestBean());
        System.out.println(singletonReferencePrototype.getMyTestBean());
        System.out.println(singletonReferencePrototype.getMyTestBean());
    }

    /**
     * 关于Sping singleton依赖prototype
     * https://juejin.cn/post/6867898278151716872
     * <p>
     * 源码分析一下spring的scoped-proxy
     * https://juejin.cn/post/6869402006017507335
     */
    @Test
    public void testMyTestBeanUseScopedProxy() {
        System.out.println("myTestBeanUseScopedProxy: ");
        MyTestBean myTestBeanUseScopedProxy1 = (MyTestBean) applicationContext.getBean("myTestBeanUseScopedProxy");
        System.out.println(myTestBeanUseScopedProxy1);

        MyTestBean myTestBeanUseScopedProxy2 = (MyTestBean) applicationContext.getBean("myTestBeanUseScopedProxy");
        System.out.println(myTestBeanUseScopedProxy2);
        System.out.println(myTestBeanUseScopedProxy1 == myTestBeanUseScopedProxy2);

        System.out.println("myTestBean: ");
        MyTestBean myTestBean1 = (MyTestBean) applicationContext.getBean("myTestBean");
        System.out.println(myTestBean1);
        MyTestBean myTestBean2 = (MyTestBean) applicationContext.getBean("myTestBean");
        System.out.println(myTestBean2);
        System.out.println(myTestBean1 == myTestBean2);
    }
}
