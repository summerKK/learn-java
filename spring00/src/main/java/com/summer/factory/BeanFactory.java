package com.summer.factory;

import com.summer.service.IAccountService;
import com.summer.service.imlp.AccountServiceImpl;
import com.summer.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Service("beanFactory")
public class BeanFactory {

    @Autowired
    @Qualifier("accountService")
    private AccountServiceImpl accountService;

    @Autowired
    private TransactionManager transactionManager;

    public final void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    // 开启事物
                    transactionManager.beginTransaction();
                    System.out.println("开启事物");
                    // 执行事物
                    result = method.invoke(accountService, args);
                    // 事物提交
                    transactionManager.commit();
                    System.out.println("事物提交");
                } catch (Exception e) {
                    // 事物回滚
                    transactionManager.rollback();
                    System.out.println("事物回滚");
                    throw new RuntimeException(e);
                } finally {
                    transactionManager.release();
                }
                return result;
            }
        });
    }
}
