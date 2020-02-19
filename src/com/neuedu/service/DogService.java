package com.neuedu.service;

import com.neuedu.dao.DogDao;
import com.neuedu.dao.IdogDao;
import com.neuedu.pojo.Dog;

import java.util.List;

/**
 * Created by 超先生 on 2020/2/19.
 */
public class DogService implements IdogService {
    IdogDao dogDao = new DogDao();
    @Override
    public List<Dog> query() {
        return dogDao.query();
    }

    @Override
    public int add(Dog dog) {

        return dogDao.add(dog);
    }

    @Override
    public int update(Dog dog) {
        return dogDao.update(dog);
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public Dog queryOne(int id) {
        return null;
    }
}
