package com.heqin.mergedbeandefinition.spring3x;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author heqin
 * @Date 2021/9/13 16:46
 */
@Configuration
public class AnnoConfig {

    @Bean
    public ComplexObject parent(){
        ComplexObject parent = new ComplexObject();
        Properties adminEmails = new Properties();
        adminEmails.put("administrator","administrator@example.com");
        adminEmails.put("support","support@example.com");
        return parent;
    }

}
