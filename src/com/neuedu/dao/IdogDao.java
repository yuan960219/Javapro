package com.neuedu.dao;

import com.neuedu.pojo.Dog;

import java.util.List;

/**
 * Created by 超先生 on 2020/2/19.
 */
public interface IdogDao {
    List<Dog> query();
    int add(Dog dog);
    int update(Dog dog);
    int del(int id);
    Dog queryOne(int id);
}
