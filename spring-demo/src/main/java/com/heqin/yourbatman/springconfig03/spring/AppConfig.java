package com.heqin.yourbatman.springconfig03.spring;

import com.heqin.yourbatman.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author heqin
 */
@ComponentScan("com.heqin.yourbatman.springconfig03.spring.bean")
@Configuration
public class AppConfig {

    @Order(2)
    @Bean
    public User user1(){
        User user = new User("user1",1);
        return user;
    }

    @Order(1)
    @Bean
    public User user2(){
        User user = new User("user2",2);
        return user;
    }
}
