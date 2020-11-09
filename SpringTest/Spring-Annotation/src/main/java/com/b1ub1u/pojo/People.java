package com.b1ub1u.pojo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.annotation.Resources;

public class People {
    private String name;
    @Autowired
    private Cat cat;
    @Resource(name="dog")
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }
}
