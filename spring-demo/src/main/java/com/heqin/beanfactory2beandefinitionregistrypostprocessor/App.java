package com.heqin.beanfactory2beandefinitionregistrypostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author heqin
 * @Date 2021/9/7 6:46
 */
//@Component("appTest")
@ComponentScan({"com.heqin.beanfactory2beandefinitionregistrypostprocessor.factorypostprocessor"})
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(bdName -> {
            System.out.println(bdName);
        });
    }
}
