package com.heqin.circulardepend.demo02;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = {"com.heqin.circulardepend.demo02"})
@EnableAspectJAutoProxy
public class App {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E:\\code\\heq\\heqinfj_fork\\1-proxySource_temp");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat.getClass());
        cat.makeSound();
        cat.printPerson();
        //ObjenesisCglibAopProxy:无需调用类的构造函数即可创建代理实例，生成的代理类中所有的属性全部都是空的
        //https://blog.csdn.net/qq_30095631/article/details/108086616
        System.out.println("cat's desc: " + cat.desc);//cat's desc: null
    }
}
