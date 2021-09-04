package com.heqin.yourbatman.springconfig02.demo01;

import com.heqin.yourbatman.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heqin
 */
@Configuration
public class AppConfig {
    @Bean
    public User user() {
        User user = new User();
        user.setName("A哥");
        user.setAge(18);
        return user;
    }
}
