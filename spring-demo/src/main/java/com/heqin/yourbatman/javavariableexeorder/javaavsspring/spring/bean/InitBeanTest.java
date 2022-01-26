package com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 根据代码演示，得出文字版结论：
 * 1. 构造函数是每个类最先执行的，这个时候，bean属性还没有被注入
 * 2. @PostConstruct优先于afterPropertiesSet执行：在这执行，属性已经完成了赋值（注入）
 *
 * 最终结论，spring中的Constructor、@PostConstruct、@Autowired、afterPropertiesSet的顺序为：
 * Constructor（构造函数） > @Autowired > @PostConstruct > afterPropertiesSet
 *
 * <p>
 * 输出结果：
 * ----> InitSequenceBean: 初始InitBeanTest的成员变量age为18
 * ----> InitSequenceBean: constructor: null
 * ----> InitSequenceBean: @Autowired: com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring.bean.DemoService@32115b28
 * ----> InitSequenceBean: @PostConstruct: com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring.bean.DemoService@32115b28
 * ----> InitSequenceBean: afterPropertiesSet: com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring.bean.DemoService@32115b28
 * ----> InitSequenceBean: onApplicationEvent
 * IOC容器初始化完成。。。
 * 准备销毁IOC容器。。。
 * ----> InitSequenceBean: @PreDestroy: com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring.bean.DemoService@32115b28
 * IOC容器销毁完成。。。
 *
 * @Author heqin
 * @Date 2021/12/12 7:33
 */
@Component
public class InitBeanTest implements InitializingBean, ApplicationListener<ContextRefreshedEvent> {

    //为了测试java的成员变量初始化与spring bean属性的注入的顺序
    public Integer age = initAge();

    private int initAge() {
        int defaultAge = 18;
        System.err.println(String.format("----> InitSequenceBean: 初始InitBeanTest的成员变量age为%s", defaultAge));
        return defaultAge;
    }

    //@Autowired//为了测试验证bean属性被注入的时机，使用下面的自动装配方法来验证
    DemoService demoService;

    //为了测试验证bean属性被注入的时机
    @Autowired
    private void setDemoService(DemoService demoService){
        System.err.println("----> InitSequenceBean: @Autowired: " + demoService);
        this.demoService = demoService;
    }

    public InitBeanTest() {
        System.err.println("----> InitSequenceBean: constructor: " + demoService);
    }

    @PostConstruct
    public void postConstruct() {
        System.err.println("----> InitSequenceBean: @PostConstruct: " + demoService);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("----> InitSequenceBean: afterPropertiesSet: " + demoService);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        System.err.println("----> InitSequenceBean: onApplicationEvent");
    }

    @PreDestroy
    public void PreDestroy() {
        System.err.println("----> InitSequenceBean: @PreDestroy: " + demoService);
    }
}
