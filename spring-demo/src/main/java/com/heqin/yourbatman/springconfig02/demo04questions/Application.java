package com.heqin.yourbatman.springconfig02.demo04questions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heqin
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 主配置类configuration
        System.out.println(context.getBean(AppConfig.class));
        System.out.println(context.getBean(AppConfig.class).getClass());
    }
}