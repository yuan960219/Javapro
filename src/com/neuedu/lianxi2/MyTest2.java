package com.neuedu.lianxi2;

import com.neuedu.pojo.Dept;
import com.neuedu.pojo.Dog;
import com.neuedu.pojo.Emp;
import com.neuedu.util.JdbcUtil;
import com.neuedu.util.MyArray;
import com.neuedu.web.DogWeb;
import javafx.scene.DepthTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超先生 on 2020/2/19.
 */
public class MyTest2 {
    public static void main(String[] args) {
        /*DogWeb dogWeb =new DogWeb();
        dogWeb.showmain();
        dogWeb.input();*/
        /*Dog dog =new Dog();
        Dog dog2 =new Dog();
        Dog dog3 =new Dog();
        Dog dog4 =new Dog();
        Dog dog5 =new Dog();
        Dog dog6 =new Dog();*/
        /*try {
            Class clz = Dog.class;
            Dog dog = new Dog();
            Class clz2 = dog.getClass();
            Class clz3 = Class.forName("com.neuedu.pojo.Dog");
            System.out.println(clz==clz2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        Class clz = Dog.class;
        /* Field[] fields =  clz.getDeclaredFields();
        System.out.println(fields.length);
        for (Field  f : fields){
            System.out.println(f.getName());
        }*/
        List<Dept> list = JdbcUtil.executeQuery("select deptno,dname,loc from dept",Dept.class);
        System.out.println(list);
    }
}
