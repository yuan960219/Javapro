package com.neuedu;

/**
 * Created by 超先生 on 2020/2/4.
 */
public class Text_two {
    public static void main(String[] args) {
        int sum=0;
        for (int i=2;i<=100;i++){
            if(i%2==0){
                sum=sum+i;
            }
        }
        System.out.println(sum);
    }
}
