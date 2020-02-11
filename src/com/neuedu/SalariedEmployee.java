package com.neuedu;

/**
 * Created by 超先生 on 2020/2/6.
 */
public class SalariedEmployee extends ColaEmployee{
    public static int salar;
    public SalariedEmployee(int salar){
        this.salar=salar;
    }
    @Override
    public double getSalary(int month) {
        return month*salar;
    }
}
