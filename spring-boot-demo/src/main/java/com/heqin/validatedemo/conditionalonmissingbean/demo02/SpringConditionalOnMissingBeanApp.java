package com.heqin.validatedemo.conditionalonmissingbean.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

/**
 * @Author heqin
 * @Date 2021/12/27 22:11
 */
@SpringBootApplication
public class SpringConditionalOnMissingBeanApp implements CommandLineRunner {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;


    public static void main(String[] args) {
        SpringApplication.run(SpringConditionalOnMissingBeanApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring service fully qualified class name: ");
        Map<String, Container> stringContainerMap = beanFactory.getBeansOfType(Container.class);
        System.out.println(stringContainerMap);
    }
}
