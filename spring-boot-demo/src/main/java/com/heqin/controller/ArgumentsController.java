package com.heqin.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @Author heqin
 * @Date 2021/9/21 22:10
 */
@Slf4j
@RestController
public class ArgumentsController {

    @Resource
    private ApplicationArguments arguments;

    @Value("${server.descContent}")
    private String serverDescContent;

    @GetMapping("/args")
    public String getArgs() {
        System.out.println("# 非选项参数数量: " + arguments.getNonOptionArgs().size());
        System.out.println("# 选项参数数量: " + arguments.getOptionNames().size());
        System.out.println("# 非选项具体参数:");
        arguments.getNonOptionArgs().forEach(System.out::println);
        System.out.println("# 选项参数具体参数:");
        arguments.getOptionNames().forEach(optionName -> {
            System.out.println("--" + optionName + "=" + arguments.getOptionValues(optionName));
        });
        return "success";
    }

    @GetMapping("/printServerDescContent")
    public String printServerDescContent(){
        System.out.println(serverDescContent);
        return "success";
    }

    @GetMapping("/printSystemProperty")
    public String printSystemProperty(){
        //null 选项参数
        System.out.println(System.getProperty("server.descContent"));
        //joe 系统参数
        System.out.println(System.getProperty("userName"));
        //null 环境变量
        System.out.println(System.getProperty("userAge"));
        return "success";
    }

}
