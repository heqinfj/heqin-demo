package com.heqin;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties({FormatProperties.class})
public class HeqinFormatConfiguration {

    @Bean
    public FormatTemplate formatTemplate(FormatProperties formatProperties,FormatProcessor formatProcessor){
        if("fastjson".equals(formatProperties.getType())){
            return new FormatTemplate(new FastjsonFormatProcessor());
        }
        if("gson".equals(formatProperties.getType())){
            return new FormatTemplate(new GsonFormatProcessor());
        }
        return new FormatTemplate(formatProcessor);
    }
}
