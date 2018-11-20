package com.lll.algorithm.sort;
import com.lll.algorithm.tool.SortTestHelper;
/**
 * qs1.0
 * 想象整个qs的设计，就是把那个位置的数不断放到正确的位置上并且将数组一分为二的递归下去。
 *
 * partion的作用是返回一个位置 p。使得 arr[l,p-1]<arr[p]<arr[p+1,r]
 * 在具体的partion函数中，循环中初始为  l，[l+1,j],[j+1,i),i就是现在要考量的值
 * j初始值为l，这样俩个初始时都是没有，但是循环时，可以不断生成新的。嘿嘿。
 *
 *
 *
 * Created by lvliangliang on 2017/12/19.
 */
public class qs1 {
//    private qs1(){}
    public static void main(String[] args) {
//        Integer[] arr= SortTestHelper.generateRandomArray(100000,0,1000);
        Integer[] arr= SortTestHelper.generateNearlyOrderedArray(1000000,100);

        SortTestHelper.testSort("com.lll.algorithm.sort.qs1",arr);
    }
    public static void sort(Comparable []arr){
        int n=arr.length;
        sort(arr,0,n-1);
    }
    public static void sort(Comparable []arr,int l,int r){
        if(l>=r)return ;
        int p=partion(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    private static int partion(Comparable[] arr, int l, int r) {
        Comparable v=arr[l];
        int j=l;
        for(int i=l+1;i<=r;i++){
            if(arr[i].compareTo(v)<0){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }
    private static void swap(Object[] arr, int i, int j) {
        Object temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
