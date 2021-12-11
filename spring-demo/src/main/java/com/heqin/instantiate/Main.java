package com.heqin.instantiate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author heqin
 * @Date 2021/9/30 17:00
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.heqin.instantiate");
        User user = applicationContext.getBean(User.class);
    }
}
