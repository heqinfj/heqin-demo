package com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author heqin
 * @Date 2021/12/12 7:46
 */
public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(BootstrapConfig.class);
        System.err.println("IOC容器初始化完成。。。");
        System.err.println("准备销毁IOC容器。。。");
        application.close();
        System.err.println("IOC容器销毁完成。。。");
    }
}
