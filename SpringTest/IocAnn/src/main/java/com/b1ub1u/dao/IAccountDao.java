package com.b1ub1u.dao;

import com.b1ub1u.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
