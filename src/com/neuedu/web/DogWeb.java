package com.neuedu.web;

import com.neuedu.pojo.Dog;
import com.neuedu.service.DogService;
import com.neuedu.service.IdogService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by 超先生 on 2020/2/19.
 */
public class DogWeb {
    IdogService dogService  = new DogService();
    public void showmain(){
        System.out.println("- - - - - - - - - - - -");
        System.out.println("1- - - - - - - - - -查询");
        System.out.println("2- - - - - - - - - -添加");
        System.out.println("3- - - - - - - - - -修改");
        System.out.println("4- - - - - - - - - -删除");
        System.out.println("其他- - - - - - - - -退出");
        System.out.println("- - - - - - - - - - - -");
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if(i==1){
            query();
        }else if(i==2){
            add(scanner);
        }else if(i==3){
            update(scanner);
        }else if(i==4){
            del(scanner);
        }else{
            System.exit(0);
        }
    }
    public void query(){
        List<Dog> List = dogService.query();
        for(Dog dog : List){
            System.out.println(dog);
        }
    }
    public void add(Scanner scanner){
        System.out.println("请输入要添加的名字");
        String name = scanner.next();
        System.out.println("请输入要添加的年龄");
        int age = scanner.nextInt();
        System.out.println("请输入性别 1-男 0-女");
        int gender = scanner.nextInt();
        Dog dog = new Dog(name,age,gender);
        dogService.add(dog);
        query();
    }
    public void update(Scanner scanner){
        System.out.println("请输入修改的id");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的名字");
        String name = scanner.next();
        System.out.println("请输入要修改的年龄");
        int age = scanner.nextInt();
        System.out.println("请输入要修改性别 1-男 0-女");
        int gender = scanner.nextInt();
        Dog dog = new Dog(id,name,age,gender);
        dogService.update(dog);
        query();
    }
    private void del(Scanner scanner){
        System.out.println("请输入要删除的id");
        int id = scanner.nextInt();
        dogService.del(id);
        query();
    }
}
