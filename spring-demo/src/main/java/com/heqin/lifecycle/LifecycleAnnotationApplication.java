package com.heqin.lifecycle;

import com.heqin.lifecycle.bean.Person;
import com.heqin.lifecycle.config.EnableTest;
import com.heqin.lifecycle.config.LifecycleConfiguration;
import com.heqin.lifecycle.postprocessor.TestBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author heqin
 */
//@Configuration的父注解类型是@Component
@Configuration
@EnableTest
public class LifecycleAnnotationApplication {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifecycleAnnotationApplication.class);
        //信息: Bean 'com.heqin.lifecycle.config.LifecycleConfiguration' of type [com.heqin.lifecycle.config.LifecycleConfiguration$$EnhancerBySpringCGLIB$$f780ca8b]
        // is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
        //不符合被所有 BeanPostProcessor 处理的条件（例如：不符合自动代理的条件）

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LifecycleAnnotationApplication.class,TestBeanPostProcessor.class);

        System.out.println("================准备刷新IOC容器==================");
        context.refresh();
        System.out.println("================IOC容器刷新完毕==================");
        context.start();
        System.out.println("================IOC容器启动完成==================");

        Person person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getAddress().getName());

        System.out.println("================准备停止IOC容器==================");
        context.stop();
        System.out.println("================IOC容器停止成功==================");
        context.close();
    }
}
