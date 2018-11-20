package com.test;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Fayne on 2018/09/08.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] data = new int[M+M];
        data[0]= Integer.valueOf(scanner.nextInt());
        String data0 = scanner.nextLine();
        String[] split = data0.split(" ");
        for(int i=1;i<split.length;i++){
            data[i]=Integer.valueOf(split[i]);
        }
        int res=0;
        int flag=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j==i)continue;
                if(getnext(j,i,data,0)){
                    flag++;
                }else{
                    flag=0;
                    break;
                }
            }
            if(flag==M+M-1)res++;
            flag=0;
        }
        System.out.println(res);
        System.out.println(Arrays.toString(data));
    }
    public static boolean getnext(int j, int i, int[] data,int num){
        int len=data.length;
        if(num>data.length)return false;
        List<Integer>list=new ArrayList<>();
        list.add(j);
        for(int m=0;m<len;m++){
            if(data[m]==j){
                if(data[m+1]==i){
                    return true;
                }else{
                    list.add(data[m+1]);
                }
            }
        }
        return false;
    }
}
