package com.heqin.lifecycle.config;

import com.heqin.lifecycle.bean.Address;
import com.heqin.lifecycle.bean.Person;
import com.heqin.lifecycle.postprocessor.TestBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heqin
 */
@Configuration
public class LifecycleConfiguration {
//    @Bean
//    public TestBeanPostProcessor testBeanPostProcessor(){
//        TestBeanPostProcessor testBeanPostProcessor = new TestBeanPostProcessor();
//        return testBeanPostProcessor;
//    }

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("xiaomi");
        return person;
    }

    @Bean
    public Address address(){
        Address address = new Address();
        address.setName("fuzhou");
        return address;
    }
}
