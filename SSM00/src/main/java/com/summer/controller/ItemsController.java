package com.summer.controller;

import com.summer.domain.Items;
import com.summer.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    // 注意这里导入的是接口,不是具体实现类.使用了aop切面.添加了事物.动态代理
    private ItemsService itemsService;

    @RequestMapping("item-detail")
    public String itemDetail(Model model) {
        Items item = itemsService.findById(1);
        model.addAttribute("item", item);
        return "itemDetail";
    }
}
