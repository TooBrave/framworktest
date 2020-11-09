package com.b1ub1u.config;

import com.b1ub1u.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration   //代表这是一个配置类
@ComponentScan("com.b1ub1u.pojo")
public class B1ub1uConfg1 {
    //注册一个bean就相当于之前的.xml里的bean标签，方法名，相当于bean标签的id，返回值相当于class属性
    @Bean
    public User getUser(){
        return new User();
    }

}
