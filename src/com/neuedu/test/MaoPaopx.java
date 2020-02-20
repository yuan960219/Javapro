package com.neuedu.test;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by 超先生 on 2020/2/20.
 */
public class MaoPaopx {
    public static void main(String[] args) {
        int[] array = {2,11,24,36,44,52,66,72,88,99};
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++)
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
        }
        for(int a : array){
            System.out.println(a);
        }
    }
}
