package com.heqin.yourbatman.javavariableexeorder.case6;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Desc 注解对执行顺序的影响
 * @Author heqin
 * @Date 2021/9/27 19:20
 */
@Component
public class InitBeanTest implements InitializingBean, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    DemoService demoService;

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
}

//执行结果：
//----> InitSequenceBean: constructor: null
//----> InitSequenceBean: @PostConstruct: com.heqin.yourbatman.javavariableexeorder.case6.DemoService@2a40cd94
//----> InitSequenceBean: afterPropertiesSet: com.heqin.yourbatman.javavariableexeorder.case6.DemoService@2a40cd94
//----> InitSequenceBean: onApplicationEvent

/**
 * 根据代码演示，得出文字版结论：
 *
 * 构造函数是每个类最先执行的，这个时候，bean属性还没有被注入
 * @PostConstruct优先于afterPropertiesSet执行：在这执行，属性已经完成了赋值（注入）
 */

