package com.heqin.circulardepend.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author heqin
 */
public class App {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.heqin.circulardepend.demo01");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);

        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat.person.getClass());
    }
}
