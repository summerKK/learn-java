package com.summer.service;

import com.summer.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void TestFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void TestFindOne() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void TestUpdate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setId(1);
        account.setMoney(12.11f);
        account.setName("Summer");
        accountService.updateAccount(account);

        Account account1 = accountService.findById(1);
        System.out.println(account1);

    }
}
