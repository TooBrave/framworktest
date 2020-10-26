package com.b1ub1u.test;

import com.b1ub1u.dao.AccountDao;
import com.b1ub1u.domain.Account;
import com.b1ub1u.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void finalize() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

//    @Test
//    public void findAllTest(){
//        List<AccountUser> accounts = accountDao.findAll();
//        for(AccountUser au : accounts){
//            System.out.println(au);
//        }
//    }
    @Test
    public void findAllTest(){
        List<Account> accounts = accountDao.findAll();
        for(Account au : accounts){
            System.out.println(au);
        }
    }
}
