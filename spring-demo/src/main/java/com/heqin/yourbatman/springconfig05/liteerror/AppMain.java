package com.heqin.yourbatman.springconfig05.liteerror;

import com.heqin.yourbatman.springconfig05.Parent;
import com.heqin.yourbatman.springconfig05.Son;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author heqin
 */
public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //配置类
        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);

        //getBean
        Son son = context.getBean(Son.class);
        Parent parent = context.getBean(Parent.class);

        System.out.println("容器内的Son实例：" + son.hashCode());
        System.out.println("容器内Parent持有的Son实例：" + parent.getSon().hashCode());
        System.out.println(parent.getSon() == son);
    }
}
