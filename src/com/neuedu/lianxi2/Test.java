package com.neuedu.lianxi2;

/**
 * Created by 超先生 on 2020/2/10.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static Mybook[] books = new Mybook[200];
    public static List<Mybook> list = new ArrayList<>();
    public static void main(String[] args) {
        inputData(list);
        menu();
 //       searchName(list,"书名5");
//        deleteName(list,"书名6");
//        addbook(list);
//        print(list);
    }
    public static void menu(){
        System.out.println("输出菜单项请选择你要进行的操作（请输入1-4中的任一个数字）:");
        System.out.println("1：添加图书");
        System.out.println("2：删除图书");
        System.out.println("3：查找图书（根据书名）");
        System.out.println("4:查看所有");
        System.out.println("5:退出");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i){
            case 1:
                addbook(list);
                break;
            case 2:
                System.out.print("输入要删除的书名：");
                String name = scanner.next();
                deleteName(list,name);
                break;
            case 3:
                System.out.println("输入要查看的书名：");
                String serchname = scanner.next();
                searchName(list,serchname);
                break;
            case 4:
                print(list);
                break;
            default:
                System.exit(1);
                break;
        }
    }
    public static void inputData(List<Mybook> books){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1;i<=n;i++){
            Mybook mybook = new Mybook("书名"+i, (double) i,"出版社"+i,"作者"+i,"ISBN"+i);
            books.add(mybook);
        }
    }
    public static void print(List<Mybook> books){
        for (int i = 0;i<books.size();i++){
            System.out.println(books.get(i));
        }
        menu();
    }
    public static void searchName(List<Mybook> books,String name){
        for (int i = 0;i<books.size();i++){
            Mybook mybook = books.get(i);
           if (mybook.getName().equals(name)){
               System.out.println(mybook);
               menu();
               return;
           }
        }
        System.out.println("此书不存在");
        menu();
    }
    public static void deleteName(List<Mybook> books,String name){
        for (int i = 0;i<books.size();i++){
            Mybook mybook = books.get(i);
            if (mybook.getName().equals(name)){
                books.remove(i);
                System.out.println("删除成功");
                menu();
                return;
            }
        }
        System.out.println("没有此书，删除失败");
        menu();
    }
    public static void addbook(List<Mybook> books){
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入书名：");
        String name = scanner.next();
        System.out.print("输入价格：");
        Double price = scanner.nextDouble();
        System.out.print("输入出版社：");
        String press = scanner.next();
        System.out.print("输入作者：");
        String author = scanner.next();
        System.out.print("输入ISBN号：");
        String bookISBN = scanner.next();
        Mybook mybook = new Mybook(name,price,press,author,bookISBN);
        books.add(mybook);
        menu();

    }
}
