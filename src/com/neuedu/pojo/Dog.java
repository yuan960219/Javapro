package com.neuedu.pojo;

/**
 * Created by 超先生 on 2020/2/19.
 */
public class Dog {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
    static {
        System.out.println("dog静态代码块");
    }
    {
        System.out.println("构造代码块");
    }
    public Dog() {
        System.out.println("构造方法");
    }

    public Dog(String name, Integer age, Integer gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Dog(Integer id, String name, Integer age, Integer gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
