package com.b1ub1u.dao.Impl;

import com.b1ub1u.dao.IAccountDao;
import com.b1ub1u.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

//public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
public class AccountDaoImpl  implements IAccountDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Account> findAllAccount() {

        List<Account> accounts =  jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }

    public Account findAccountById(Integer accountId) {

        List<Account> accounts = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.get(0);

    }

    public void saveAccount(Account account) {

        jdbcTemplate.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());

    }

    public void updateAccount(Account account) {

        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

    }

    public void deleteAccount(Integer accountId) {

        jdbcTemplate.update("delete from account where id=?",accountId);

    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts =  jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class),accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果不唯一");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}


