package com.neuedu;

/**
 * Created by 超先生 on 2020/2/7.
 */
public class HourlyEmployee extends ColaEmployee {
    public int hour_salar;
    public int month_hour;
    public HourlyEmployee(int hour_salar,int month_hour){
        this.hour_salar=hour_salar;
        this.month_hour=month_hour;
    }
    @Override
    public double getSalary(int month) {
        if (month_hour>160){
            return ((month_hour-160)*1.5+160)*hour_salar;
        }
        else {
            return month_hour*hour_salar;
        }

    }
}
