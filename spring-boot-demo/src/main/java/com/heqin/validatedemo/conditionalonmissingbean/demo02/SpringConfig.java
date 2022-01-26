package com.heqin.validatedemo.conditionalonmissingbean.demo02;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author heqin
 * @Date 2021/12/28 10:54
 */
@Configuration
public class SpringConfig {

    @Bean
    //@ConditionalOnMissingBean
    @ConditionalOnMissingBean(value = Book.class, parameterizedContainer = Container.class)
    public Container<Book> bookContainer(){
        return new Container<>(new Book());
    }

    @Bean
    //@ConditionalOnMissingBean
    @ConditionalOnMissingBean(value = Computer.class, parameterizedContainer = Container.class)
    public Container<Computer> computerContainer(){
        return new Container<>(new Computer());
    }

}
