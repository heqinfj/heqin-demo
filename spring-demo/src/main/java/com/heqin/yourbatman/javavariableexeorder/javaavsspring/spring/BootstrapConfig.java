package com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @Author heqin
 * @Date 2021/12/12 7:36
 */
//如果只有属性value，则value可以省略
@ComponentScans(value = {
        @ComponentScan(value = "com.heqin.yourbatman.javavariableexeorder.javaavsspring.spring.bean")
})
@Configuration
public class BootstrapConfig {
}
