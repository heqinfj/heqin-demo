package com.heqin.validatedemo.conditionalonmissingbean.demo01;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author heqin
 * @Date 2021/12/27 22:12
 */
@Configuration
public class SpringConfig {

    @Bean
    //@ConditionalOnMissingBean
    //@ConditionalOnMissingBean(type = "com.heqin.validatedemo.conditionalonmissingbean.demo01.SpringService")
    //@ConditionalOnMissingBean(value = SpringService.class)
    //@ConditionalOnMissingBean(name = {"springService","abc"})
    //@ConditionalOnMissingBean(search = SearchStrategy.CURRENT)
    //@ConditionalOnMissingBean(annotation = Service.class)
    //@ConditionalOnMissingBean(ignored = AnotherSpringService.class)
    //@ConditionalOnMissingBean(ignoredType = "com.heqin.validatedemo.conditionalonmissingbean.demo01.AnotherSpringService")
    //@ConditionalOnMissingBean(parameterizedContainer = AnotherSpringService.class)
    @ConditionalOnMissingBean(value = RequiredBean.class, parameterizedContainer = AnotherSpringService.class)
    public SpringService springService() {
        System.out.println("------------------- springService -------------------");
        return new SpringService();
    }

    @Bean
    public AnotherSpringService<RequiredBean> anotherSpringService() {
        System.out.println("------------------- anotherSpringService -------------------");
        return new AnotherSpringService<>();
    }

    @Bean
    public AnotherSpringService<OneRequiredBean> anotherSpringService2() {
        System.out.println("------------------- anotherSpringService2 -------------------");
        return new AnotherSpringService<>();
    }

    @Bean
    //@ConditionalOnMissingBean(parameterizedContainer = AnotherSpringService.class)
    //@ConditionalOnMissingBean(value = RequiredBean.class, parameterizedContainer = AnotherSpringService.class)
    @ConditionalOnMissingBean(value = OneRequiredBean.class, parameterizedContainer = AnotherSpringService.class)
    public SpringService springService2() {
        System.out.println("------------------- springService2 -------------------");
        return new SpringService();
    }
}
