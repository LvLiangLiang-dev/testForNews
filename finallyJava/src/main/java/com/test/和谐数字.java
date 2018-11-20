package com.test;

import java.util.Scanner;
public class 和谐数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long once=0,temp=0;
        int t = scanner.nextInt();
        long []data=new long[t+1];
        for(int i=1;i<t+1;i++){
            data[i]=scanner.nextLong();
        }
        for(int k=1;k<t+1;k++){
            temp=data[k];
            while(data[k]>10){
                once+=data[k]-data[k]/10*10;
                data[k]=data[k]/10;
            }
            once+=data[k];
            if(temp%once==0) System.out.println("Yes");
            else System.out.println("No");
            once=0;
        }
    }
}
//
//    private static void test23() {
//        int t=2;
//        long []data=new long[t+1];
//        data[1]=112;
//        data[2]=342;
//        long once=0;
//        for(int k=1;k<t+1;k++){
//            while(data[k]>10){
//                once+=data[k]-data[k]/10*10;
//                data[k]=data[k]/10;
//            }
//            once+=data[k];
//            System.out.println(once);
//            if(once%k==0) System.out.println("YES");
//            else System.out.println("NO");
//            once=0;
//        }
//    }
//
//    private static void test() {
//
//    }