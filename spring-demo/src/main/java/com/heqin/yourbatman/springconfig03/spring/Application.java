package com.heqin.yourbatman.springconfig03.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heqin
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
