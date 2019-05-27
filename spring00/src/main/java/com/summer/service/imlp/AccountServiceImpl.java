package com.summer.service.imlp;

import com.summer.dao.IAccountDao;
import com.summer.domain.Account;
import com.summer.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void delAccount(Integer id) {
        accountDao.delAccount(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account sourceAccount = accountDao.findByName(sourceName);
        Account targetAccount = accountDao.findByName(targetName);
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);

        accountDao.updateAccount(sourceAccount);
        accountDao.updateAccount(targetAccount);
    }
}
