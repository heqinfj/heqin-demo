package com.heqin.yourbatman.springconfig04;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ClassUtils;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);
        System.out.println(appConfig.getClass().getSuperclass() == AppConfig.class);
        System.out.println(AopUtils.isCglibProxy(appConfig));
        System.out.println(ClassUtils.isCglibProxy(appConfig));
    }
}
/**
 * 结果如下：
 * com.heqin.yourbatman.springconfig04.AppConfig$$EnhancerBySpringCGLIB$$e943ad@45afc369
 * true
 * false
 * true
 */