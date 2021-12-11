package com.heqin.demo.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author heqin
 * @Date 2021/12/8 11:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Bootstrap.class})
public class BootstrapTest {

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Test
    public void testAutoConfigurationPackages(){
        List<String> stringList = AutoConfigurationPackages.get(beanFactory);
        stringList.forEach(str -> System.out.println(str));
    }

    @Test
    public void testThreadPoolExecutor(){
        System.out.println(threadPoolExecutor.getCorePoolSize());
    }
}
