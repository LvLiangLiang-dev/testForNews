package com.lll.algorithm.sort;

import com.lll.algorithm.tool.SortTestHelper;

import java.util.Random;

import static org.apache.lucene.util.ArrayUtil.swap;

/**
 * 1：插入优化，r-l<15选用插入排序,n小时，系数影响大，而且插入排序的系数比qs的系数小。
 * 2：随机优化，如果数组有序度超级高，那么递归树平衡度极低，都是一边大，一般几乎没有，
 *      所以要随机化初始值。
 * Created by lvliangliang on 2017/12/19.
 */
public class qs1_5 {
    private qs1_5() {}

    public static void main(String[] args) {
//        Comparable arr[] = SortTestHelper.generateNearlyOrderedArray(100000, 10);
        Comparable arr[] = SortTestHelper.generateRandomArray(1000000,0,1000000);
        SortTestHelper.testSort("com.lll.algorithm.sort.qs1", arr);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        int p = partion(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partion(Comparable[] arr, int l, int r) {
        int j = l;

        int randNum = (int) (Math.random() * (r - l + 1)) + l;
        System.out.println("randNum: "+randNum);
        swap(arr, l, randNum);

        Comparable v = arr[l];
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }
}
