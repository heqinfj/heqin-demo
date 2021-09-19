package com.heqin.placeholder.xml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

/**
 * @Desc systemEnvironment（System.getenv()） 与 systemProperties （System.getProperties()） 的区别
 * @Author heqin
 * @Date 2021/9/12 6:14
 */
public class SystemEnviromentAndSystemPropertiesTest {
    public static void main(String[] args) {
        commonMethod();
    }
    @Test
    public void testA(){
        commonMethod();
    }

    private static void commonMethod(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("placeholder/bean.xml");
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        System.out.println("===========================systemEnvironment===========================");
        System.out.println("jdbc.username: " + systemEnvironment.get("jdbc.username"));
        //systemEnvironment.forEach((k,v)-> System.out.println(k + ":" + v));
        Map<String, Object> systemProperties = environment.getSystemProperties();
        System.out.println("===========================systemProperties===========================");
        //systemProperties.forEach((k,v)-> System.out.println(k + ":" + v));
        System.out.println("jdbc.username: " + systemProperties.get("jdbc.username"));
    }
}
