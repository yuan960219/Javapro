package com.neuedu;

/**
 * Created by 超先生 on 2020/2/6.
 */
public abstract class Shape {
    public int area;
    public int per;
    public String color;
    public Shape(){

    }
    public Shape(String color){
        this.color= color;
    }
    public abstract double getArea();
    public abstract double getPer();
    public abstract void showAll();

}
