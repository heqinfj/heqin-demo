package com.heqin;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootDemoApplication.class})
//@SpringBootTest
public class SpringBootDemoApplicationByJunit4Tests {

    @Resource
    private ApplicationArguments arguments;

    @Test
    public void applicationArgumentsTest() {
        log.info("arguments:{}", Arrays.toString(arguments.getSourceArgs()));
    }
}
