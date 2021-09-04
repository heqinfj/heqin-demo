package com.heqin.yourbatman.springconfig02.demo04questions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 主配置类configuration
 * @author heqin
 */
@ComponentScan("com.heqin.yourbatman.springconfig02.demo04questions")
@Configuration//full模式 proxyBeanMethods 默认为true
//@Configuration(proxyBeanMethods = true)//full模式 proxyBeanMethods 默认为true
//@Configuration(proxyBeanMethods = false)//lite模式
//@Component//lite模式
public class AppConfig {
}
