package com.summer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class HelloController {

    @Autowired
    private DataSource datasource;

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello() {
        return "hello world";
    }
}
