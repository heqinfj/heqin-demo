package com.heqin.validatedemo.conditionalonmissingbean.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author heqin
 * @Date 2021/12/27 22:11
 */
@SpringBootApplication
public class SpringConditionalOnMissingBeanApp implements CommandLineRunner {

    @Autowired
    private SpringService springService;

    public static void main(String[] args) {
        SpringApplication.run(SpringConditionalOnMissingBeanApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring service fully qualified class name: " + springService.getClass());
    }
}
