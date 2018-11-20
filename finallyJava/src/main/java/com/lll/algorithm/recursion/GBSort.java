package com.lll.algorithm.recursion;

import java.util.Arrays;

/**
 * java数据结构和算法中 递归一章中最后一个递归的例子。
 *
 * 很好的排序算法，时间复杂度o(n*logn)
 * 一个缺点是它需要在存储器中有另一个大小等于被排序数组的数组，所以如果空间无所谓，归并排序很不错~
 *
 * 归并算法的中心是归并俩个已经有序的数组，归并俩个有序数
 *
 * 速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项性对有序的数列
 * 还有一种用途是 求逆数对数
 *
 *
 * 改进：！！！！
 *  1：如果是有序性较好的数组，可以在俩个递归后面，归并前加上一个条件，只有后半的第一个数比前半的最后一个数小的时候才进行归并
 *     如果不是，就直接返回上一级，这样可以省下不少时间。
 *  2: 归并排序在数目很小的时候
 *      当n小的时候，有序的概率大
 *      当n小的时候，n前面的系数影响很大，而且插入排序的系数要比归并排序的系数小，所以在这里用插入排序，
 *          能够稍微优化。
 *  3：自底向上的归并排序，可以非常好的利用nlogn的时间对链表进行排序。
 *
 *
 * Created by lvliangliang on 2017/12/08.
 */
public class GBSort {
    private static final int[] NUMBERS =
            {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(NUMBERS));
        sort(NUMBERS);
    }

    private static void sort(int[] numbers) {
        gbsort(numbers,0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }

    private static void gbsort(int[] number, int left, int right) {
        if(left<right){
            int mid=(left+right)/2;
            gbsort(number,left,mid);
            gbsort(number,mid+1,right);
            merge(number,left,mid,right);
        }
    }

    private static void merge(int[] numberss, int left, int mid, int right) {
        int temp[]=new int[numberss.length];
        int cen=mid+1;
        int tt=left;
        int ttt=left;
        while(left<=mid&&cen<=right){
            if(numberss[left]<=numberss[cen]){
                temp[tt++]=numberss[left++];
            }else{
                temp[tt++]=numberss[cen++];
            }
        }
        while(left<=mid){
            temp[tt++]=numberss[left++];
        }
        while(cen<=right){
            temp[tt++]=numberss[cen++];
        }
        while(ttt<=right){
            numberss[ttt]=temp[ttt++];
        }
    }
}
