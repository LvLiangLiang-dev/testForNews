package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/11
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        Integer[][] high=new Integer[n][2];
        for(int i=0;i<n;i++){
            high[i][0]=scanner.nextInt();
            high[i][1]=i+1;
        }
        int minStable=0;
        int doNum=0;
        int [][]res=new int[k][2];
        twoSort(high,0);
        while(high[n-1][0]-high[0][0]>0&&doNum<=k){
            high[n-1][0]--;
            high[0][0]++;
            res[doNum][0]=high[n-1][1];
            res[doNum][1]=high[0][1];
            doNum++;
            twoSort(high,0);
        }
        minStable=high[n-1][0]-high[0][0];
        System.out.println(minStable+" "+doNum);
        for(int i=0;i<doNum;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }




    void testMethod(){
        Integer temp[][]={{1,2},{10,11},{4,2}};
        twoSort(temp,0);
        for(int i=0;i<temp.length;i++)
            System.out.println(temp[i][0]+":"+temp[i][1]);
        int temp2[]={1,3,5,7,8};
        System.out.println(floor(temp2,6));
    }
    private static void q1(){
        Scanner scanner = new Scanner(System.in);
        int N =scanner.nextInt();
        int M =scanner.nextInt();
        Integer [][]work=new Integer[N][2];
        for(int i=0;i<N;i++){
            work[i][0]=scanner.nextInt();
            work[i][1]=scanner.nextInt();
        }
        twoSort(work,0);
        int []friend=new int[M];
        for(int i=0;i<M;i++){
            friend[i]=scanner.nextInt();
        }
        int []res=new int[M];
        int []record=new int[N];
        for(int i=0;i<N;i++)
            record[i]=work[i][0];
        for(int i=0;i<M;i++){
            res[i]=work[floor(record,friend[i])][1];
//            for(int j=0;j<N;j++){
//                if(work[j][0]<=friend[i]){
//                    if(res[i]<=work[j][1])
//                        res[i]=work[j][1];
//                }
//            }
        }
        for(int i:res){
            System.out.println(i);
        }
    }

    private static void twoSort(Integer[][] work, int i) {
        List<Integer[]> helperList= Arrays.asList(work);
        Collections.sort(helperList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[i].compareTo(o2[i]);
            }
        });
        work=(Integer [] [])helperList.toArray();
    }

    private static int floor(int[] arr,int target){
        int l=0,r=arr.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=target){
                r=mid-1;
            }else{
                l=mid;
            }
        }
        if(l+1<arr.length&&arr[l+1]==target)return l+1;
        return l;
    }
}
