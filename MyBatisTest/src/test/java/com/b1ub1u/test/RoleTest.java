package com.b1ub1u.test;

import com.b1ub1u.dao.RoleDao;
import com.b1ub1u.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
    }

    @After
    public void finalize() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAllTest(){
        List<Role> roles = roleDao.findAll();
        for(Role role : roles){
            System.out.println("-------------------------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
