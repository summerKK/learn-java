package com.summer.service;

import com.summer.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// 替换Junit runner
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit 用xml还是注解方式加载容器
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void TestFindAll() {
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void TestFindOne() {
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void TestUpdate() {
        Account account = new Account();
        account.setId(1);
        account.setMoney(12.11f);
        account.setName("Summer");
        accountService.updateAccount(account);

        Account account1 = accountService.findById(1);
        System.out.println(account1);

    }

    @Test
    public void TestTransfer() {
        accountService.transfer("ccc", "bbb", 100f);
        System.out.println(accountService.findByName("ccc"));
        System.out.println(accountService.findByName("bbb"));
    }
}
