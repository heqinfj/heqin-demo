package com.heqin.componentscanfilter.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 验证@ComponentScan的excludeFilters与includeFilters
 *
 * @Author heqin
 * @Date 2021/11/5 15:20
 */
public class AppTest {

    @Before
    public void initialize() {

    }

    @Test
    public void testExcludeFilters() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExcludeFiltersConfiguration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName ->
                System.out.println(beanDefinitionName)
        );
    }

    @Test
    public void testIncludeFilters() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IncludeFiltersConfiguration.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName ->
                System.out.println(beanDefinitionName)
        );
    }
}
