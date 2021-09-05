package com.heqin;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 配置类，条件注解
 */
@Configuration
public class FormatAutoConfiguration {

    @Bean
    @Primary
    @ConditionalOnClass(JSON.class)
    public FormatProcessor fastjsonFormat() {
        return new FastjsonFormatProcessor();
    }

    @Bean
    @ConditionalOnClass(Gson.class)
    public FormatProcessor gsonFormat() {
        return new GsonFormatProcessor();
    }
}
