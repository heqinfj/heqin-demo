package com.heqin.yourbatman.springconfig05.full;

import com.heqin.yourbatman.springconfig05.Parent;
import com.heqin.yourbatman.springconfig05.Son;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heqin
 */
@Configuration(proxyBeanMethods = true)
public class AppConfig {

    @Bean
    public Son son() {
        Son son = new Son();
        System.out.println("son created..." + son.hashCode());
        return son;
    }

    @Bean
    public Parent parent() {
        Parent parent = new Parent(son());
        System.out.println("parent created...持有的son是：" + parent.getSon().hashCode());
        return parent;
    }
}
