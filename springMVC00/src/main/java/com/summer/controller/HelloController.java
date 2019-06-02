package com.summer.controller;

import com.summer.domain.Info;
import com.summer.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(path = "/say-hello")
    public String sayHello() {
        System.out.println("Hello World!");
        return "success";
    }

    @RequestMapping(path = "/params", method = {RequestMethod.POST})
    public String getParams(Info info) {
        System.out.println(info);
        return "success";
    }

    @RequestMapping(path = "/user")
    public String getUser(User user) {
        System.out.println(user);
        return "success";
    }
}
