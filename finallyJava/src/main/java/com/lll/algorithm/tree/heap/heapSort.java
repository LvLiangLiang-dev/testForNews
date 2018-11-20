package com.lll.algorithm.tree.heap;

import com.lll.algorithm.tool.SortTestHelper;

import java.util.Arrays;

/**
 * 堆排序 1.0
 *
 * 堆排序 2.0
 *      将n个元素逐个插入到一个空堆中，算法复杂度是o(nlogn)
 *      heapify的过程，算法复杂度是o(n)
 *
 * 更多的是动态数据的维护，nlogn级别，不过比快速排序和归并排序要慢
 *
 * * Created by lvliangliang on 2017/12/20.
 */
public class heapSort {

    public static void main(String[] args) {
        Integer [] arr=SortTestHelper.generateRandomArray(90,0,90);

        heapSort1(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
    }

    public static void heapSort1(Integer[] arr){
        Heap<Integer> heap=new Heap<>(100);
        for(int i=0;i<90;i++)
            heap.insert(arr[i]);
        for(int i=89;i>=0;i--){
            arr[i]=heap.outElement();
        }
    }
    public static void heapSort2(Integer []arr){
        int n=arr.length;
        Heap<Integer> heap=new Heap<Integer>(100);
        for(int i=0;i<n;i++)
            heap.data[i+1]=arr[i];
        for(int i=n/2;i>0;i--){
            heap.shiftdown(i);
        }
        for(int i=89;i>=0;i--){
            arr[i]=heap.outElement();
        }

    }


}
