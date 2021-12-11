package com.heqin.componentscanfilter.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author heqin
 * @Date 2021/11/5 15:14
 */
@Configuration
@ComponentScan(value = "com.heqin.componentscanfilter",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)},
        useDefaultFilters = true)
public class IncludeFiltersConfiguration {
}
