package com.heqin.yourbatman.springconfig02.demo02lite;

import com.heqin.yourbatman.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author heqin
 */
@Component
//@Configuration(proxyBeanMethods = false) // 这样也是Lite模式
public class LiteConfig {
    @Bean
    public User user() {
        User user = new User();
        user.setName("A哥-lite");
        user.setAge(18);
        return user;
    }

    @Bean
    private final User user2() {
        User user = new User();
        user.setName("A哥-lite2");
        user.setAge(18);
        // 模拟依赖于user实例 看看是否是同一实例
        System.out.println(System.identityHashCode(user()));
        System.out.println(System.identityHashCode(user()));
        return user;
    }

    //@Configuration(proxyBeanMethods = true)
    //@Configuration(proxyBeanMethods = false)
    public static class InnerConfig {
        @Bean
        //private final User userInner() { // 只在lite模式下才好使
        public User userInner() {
            User user = new User();
            user.setName("A哥-lite-inner");
            user.setAge(18);
            return user;
        }
    }
}