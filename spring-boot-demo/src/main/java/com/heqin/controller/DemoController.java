package com.heqin.controller;

import com.heqin.FormatTemplate;
import com.heqin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private FormatTemplate formatTemplate;

    @RequestMapping("/formatTest")
    public String formatTest() {
        User user = new User();
        user.setId(1);
        user.setName("Tom");
        user.setTel("0591898900012");
        return formatTemplate.doFormat(user);
    }
}
