package com.summer;

import com.summer.dao.ItemsDao;
import com.summer.domain.Items;
import com.summer.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {

    @Test
    public void findByIdTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsDao bean = context.getBean(ItemsDao.class);
        Items item = bean.findById(1);
        System.out.println(item);

        ItemsService itemsService = context.getBean(ItemsService.class);
        Items items = itemsService.findById(1);
        System.out.println(items);
    }
}
