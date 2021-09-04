package com.heqin.yourbatman.springconfig05.liteerror;

import com.heqin.yourbatman.springconfig05.Parent;
import com.heqin.yourbatman.springconfig05.Son;
import org.springframework.context.annotation.Bean;

/**
 * @author heqin
 */
public class AppConfig {

    @Bean
    public Son son() {
        Son son = new Son();
        System.out.println("son created..." + son.hashCode());
        return son;
    }

    @Bean
    public Parent parent() {
        /**
         *  Method annotated with @Bean is called directly. Use dependency injection instead.
         *  Inspection info:
         *  Spring Framework 5.2 has introduced an optimization for @Configuration class processing that can be enabled via an attribute @Configuration(proxyBeanMethods = false).
         *  If you disable proxyBeanMethods the proxy instances are no longer created and calling the method invokes it again (returning a new instance every time).
         *  As a result, you have no guarantee that you're actually injecting the corresponding bean in the context.
         */
        Parent parent = new Parent(son());
        System.out.println("parent created...持有的son是：" + parent.getSon().hashCode());
        return parent;
    }
}
