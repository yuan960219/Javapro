package com.neuedu;

/**
 * Created by 超先生 on 2020/2/6.
 */
//冒泡排序
public class Bubble_sort {
    public static void main(String[] args) {
        int []marray={10,24,52,34,55,15,91,46,78,100,30,69};
        for(int i=0;i<marray.length-1;i++){
            int flag=0;
            for(int j=0;j<marray.length-i-1;j++){
                if(marray[j]>marray[j+1]){
                    int temp=marray[j];
                    marray[j]=marray[j+1];
                    marray[j+1]=temp;
                    flag++;
                }
            }
            if(flag==0){
                break;
            }
        }
        for(int a:marray){
            System.out.println(a);
        }
    }
}

