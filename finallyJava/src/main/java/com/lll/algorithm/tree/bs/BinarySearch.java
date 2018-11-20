package com.lll.algorithm.tree.bs;

import com.lll.algorithm.tool.SortTestHelper;
import org.apache.lucene.search.Sort;

import java.util.Arrays;

/**
 * 二分查找法
 * 三种模式
 * 为什么发现这种算法到第一次实现这种算法隔了20年？嘿嘿。
 *      1:bs1 简单的while循环，一直在变上下界，直到左界大于右界
 *      2:bs2 递归解决，只要考虑每次问题，然后不同情况俩个递归；只是递归要当做返回值来做，不然无法进行递归。
 *      3:
 * Created by lvliangliang on 2017/12/20.
 */
public class    BinarySearch {
    public static void main(String[] args) {
        Integer arr[] = SortTestHelper.generateRandomArray(100, 0, 100);
        System.out.println("before : " + Arrays.toString(arr));
        SortTestHelper.testSort("com.lll.algorithm.sort.QuickSort", arr);
        System.out.println("after : " + Arrays.toString(arr));

        int search = 33;
//        int result = bs1(arr, search);
        int result=bs2(arr,search,0,arr.length);
        int result_floor=floor(arr,search,0,arr.length);
        int result_ceil=ceil(arr,search,0,arr.length);


        System.out.println("result: " + result);
        System.out.println("the result in arr is :" + arr[result]);
    }

    private static int floor(Integer[] arr, int search, int l, int r) {


        return 0;
    }

    private static int ceil(Integer[] arr, int search, int i, int length) {

        return 0;
    }

    private static int bs2(Integer[] arr, int search1, int l, int r) {

        int mid = l + (r - l) / 2;
//
//        if(arr[mid]==search1)return mid;
//        else if(l>r) return -1;
//        else if(arr[mid]<search1) return bs2(arr,search1,mid+1,r);
//        else return bs2(arr,search1,l,mid-1);

        if (l <= r) {
            if (arr[mid] == search1) return mid;
            if (arr[mid] > search1)
                return bs2(arr, search1, l, mid - 1);
            else
                return bs2(arr, search1, mid + 1, r);
        } else
            return 1;

    }

    private static int bs1(Integer[] arr, int search) {
        int l = 0, r = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //int mid=(l+r)/2;
            //上述的求中可能导致溢出0
            if (arr[mid] == search) {
                return mid;
            }
            if (arr[mid] > search) {
                r = mid - 1;
            }
            if (arr[mid] < search) {
                l = mid + 1;
            }
        }
        return -1;
    }



}
