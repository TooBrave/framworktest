package com.b1ub1u.service;

import com.b1ub1u.dao.IAccountDao;
import com.b1ub1u.domain.Account;

import java.util.List;

/**
 * 事务控制应该都在业务层
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;


    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }



    public List<Account> findAllAccount() {


            List<Account> accounts = accountDao.findAllAccount();

            return accounts;

    }

    public Account findAccountById(Integer accountId) {


            Account account = accountDao.findAccountById(accountId);

            return account;

    }

    public void saveAccount(Account account) {


            accountDao.saveAccount(account);

    }

    public void updateAccount(Account account) {


            accountDao.updateAccount(account);


    }

    public void deleteAccount(Integer accountId) {


            accountDao.deleteAccount(accountId);


    }

    public void transfer(String sourceName, String targetName, Float money) {


            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);

//            int i = 10 / 0;
            accountDao.updateAccount(target);


    }
}
