package com.summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(path = "/say-hello")
    public String sayHello() {
        System.out.println("Hello World!");
        return "success";
    }
}
