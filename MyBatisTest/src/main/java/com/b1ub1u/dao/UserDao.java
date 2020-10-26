package com.b1ub1u.dao;

import com.b1ub1u.domain.QueryVo;
import com.b1ub1u.domain.User;
import java.util.List;

public interface UserDao {
    List<User> findAll();

    int insertUser(User user); //返回类型为int 表示影响条数

    int deleteById(int id);

    int updateUser(User user);

    User findById(int uid);

    List<User> findByName(String name);

    int calTotal();

    List<User> findByVo(QueryVo vo);

    //动态SQL
    List<User> findByUser(User user);

    List<User> findByIds(QueryVo vo);

    List<User> findAllUA();
}
