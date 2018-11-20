package com.lll.algorithm.sort;

import static org.apache.commons.lang3.ArrayUtils.swap;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import com.lll.algorithm.tool.SortTestHelper;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/7/27
 */
public class lastForSort {
    int n=10;
    Integer[] num = SortTestHelper.generateRandomArray(n, 0, 100);

    public static void main(String[] args) {
        int []temp={1,2,3};
        System.out.println(temp.length);
    }
    @Test
    void testSort(){
        System.out.println("before: "+SortTestHelper.isSorted(num));
//        System.out.println("bubble : "+SortTestHelper.isSorted(bubbleSort(num,n)));
//        System.out.println("bubble2: "+SortTestHelper.isSorted(bubbleSort2(num,n)));
//        quickSort(num,0,n-1);
//        System.out.println("quick  : "+SortTestHelper.isSorted(num));
//        System.out.println("insert  : "+SortTestHelper.isSorted(insertSort(num,n)));
//        System.out.println("shell  : "+SortTestHelper.isSorted(shellSort(num,n)));
        System.out.println("chose  : "+SortTestHelper.isSorted(choseSort(num,n)));
//        for(int i:bubbleSort(num,n)){
//            System.out.print(i+" ");
//        }
    }
    public Integer[] bubbleSort(Integer [] num,int n){
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-i-1;j++){
                if(num[j]>num[j+1]){
                    swaps(num,j+1,j);
                }
            }
            return num;
    }

    private void swaps(Integer[] num, int i, int j) {
        int temp=0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public Integer[] insertSort(Integer[] num, int n){
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(num[j]<num[j-1])
                    swaps(num,j,j-1);
                else
                    break;

            }
        }
        return num;
    }

    public Integer[] shellSort(Integer [] num,int n){
        for(int i=1;i<n;i++){
            int j;
            int e=num[i];
            for(j=i;j>0;j--){
                if(num[j-1]>e){
                    num[j]=num[j-1];
                }else
                    break;
            }
            num[j]=e;
        }
        return num;

    }


    public void quickSort(Integer [] num,int l,int r){
        if(l>=r)return;
        int p=partion(num,l,r);
        quickSort(num,l,p-1);
        quickSort(num,p+1,r);
    }

    private int partion(Integer[] num, int l, int r) {
        int v=num[l];
        int j=l;
        //v [l+1,j][j+1,i)
        for(int i=l+1;i<=r;i++){
            if(num[i]<v){
                swaps(num,++j,i);
            }
        }
        swaps(num,j,l);
        return j;
    }

    public Integer[] choseSort(Integer [] num, int n){
        for(int i=0;i<n;i++){
            int min=i;

            for(int j=i+1;j<n;j++){
                if(num[j]<num[min]){
                    min=j;
                }
            }
            swaps(num,i,min);
        }
        return num;
    }
}
