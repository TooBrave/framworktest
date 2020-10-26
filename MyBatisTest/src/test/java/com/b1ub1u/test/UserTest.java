package com.b1ub1u.test;

import com.b1ub1u.domain.QueryVo;
import com.b1ub1u.dao.UserDao;
import com.b1ub1u.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After
    public void finalize() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAllTest(){
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println("-----------每个用户的信息---------------");
            System.out.println(user);
        }
    }

    @Test
    public void insertUserTest(){
        User user = new User();
//        user.setUsername("linlin");
//        user.setAddress("北京");
//        user.setBirthday(new Date());
//        user.setSex("男");
        user.setUserName("linlin");
        user.setUserAddress("北京");
        user.setUserBirthday(new Date());
        user.setUserSex("男");

        int num = userDao.insertUser(user);
        System.out.println("-----------插入的用户信息---------------");
        System.out.println(user);
    }
//
    @Test
    public void deleteByIdTest(){
        int num = userDao.deleteById(56);
        System.out.println("影响条数 : " + num);
    }

    @Test
    public void updateUserTest(){
        User user = new User();
//        user.setUsername("hpy");
//        user.setAddress("山西");
//        user.setBirthday(new Date());
//        user.setSex("女");
//        user.setId(55);
        user.setUserName("hpy");
        user.setUserAddress("山西");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        user.setUserId(55);
        int num = userDao.updateUser(user);
        System.out.println("影响条数 : " + num);
    }

    @Test
    public void findByIdTest(){
        User user = userDao.findById(45);
        System.out.println("-----------每个用户的信息---------------");
        System.out.println(user);
    }

    @Test
    public void findByNameTest(){
        List<User> users = userDao.findByName("%王%");
        for(User user : users){
            System.out.println("-----------每个用户的信息---------------");
            System.out.println(user);
        }
    }



    @Test
    public void calTotalTest(){
        int total = userDao.calTotal();
        System.out.println("总条数为:" + total);
    }

    @Test
    public void findByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
//        user.setAddress("%顺义%");
        user.setUserAddress("%顺义%");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
        for(User u : users){
            System.out.println("-----------每个用户的信息---------------");
            System.out.println(u);
        }
    }
    //动态SQL
    @Test
    public void findByUserTest(){
        User u = new User();
        u.setUserName("%王%");
        u.setUserAddress("%顺义%");
        List<User> users = userDao.findByUser(u);
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void findByIdsTest(){
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(45);
        ids.add(46);
        ids.add(47);
        ids.add(48);
        ids.add(49);
        vo.setIds(ids);
        List<User> users = userDao.findByIds(vo);
        for(User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void findAllUA(){
        List<User> users = userDao.findAllUA();
        for(User user : users){
            System.out.println("-----------每个用户的信息---------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    
}
