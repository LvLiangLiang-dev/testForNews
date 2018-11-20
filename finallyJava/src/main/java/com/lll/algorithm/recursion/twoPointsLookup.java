package com.lll.algorithm.recursion;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 递归的二分查找
 * 算是分治算法的一个例子。把一个大问题分成俩个相对来说更小的问题，并且分别解决每一个小问题。
 * 分治算法一般用递归。
 * 分治算法常常是一个方法，在这个方法中含有俩个对自身的递归调用，分别对应问题的俩个部分。
 * 在二分查找中，就有俩个这样的调用，但是只有一个真正执行了。（调用哪个取决于关键字的值）
 * 不同于归并排序，它是真正执行了俩个递归调用。
 *
 * Created by lvliangliang on 2017/12/08.
 */
public class twoPointsLookup {
    static int[] array={0, 3, 12, 27, 48, 75, 108, 147, 192, 243, 300, 363, 432, 507, 588, 675, 768, 867, 972, 1083, 1200, 1323, 1452, 1587, 1728, 1875, 2028, 2187, 2352, 2523, 2700, 2883, 3072, 3267, 3468, 3675, 3888, 4107, 4332, 4563, 4800, 5043, 5292, 5547, 5808, 6075, 6348, 6627, 6912, 7203, 7500, 7803, 8112, 8427, 8748, 9075, 9408, 9747, 10092, 10443, 10800, 11163, 11532, 11907, 12288, 12675, 13068, 13467, 13872, 14283, 14700, 15123, 15552, 15987, 16428, 16875, 17328, 17787, 18252, 18723, 19200, 19683, 20172, 20667, 21168, 21675, 22188, 22707, 23232, 23763, 24300, 24843, 25392, 25947, 26508, 27075, 27648, 28227, 28812, 29403};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        while(true){
            Scanner scanner=new Scanner(System.in);
            int a=scanner.nextInt();
            System.out.println("your input is :"+a);
            System.out.println(find(a,0,99));
            System.out.println(array[find(a,0,99)]);
        }
    }
    private static int find(int i2, int low, int high) {
        int cur=(low+high)/2;
        if(array[cur]==i2){
            return cur;
        }else if(low>high){
            return Integer.MAX_VALUE;
        }else{
            if(array[cur]<i2){
                return find(i2,cur+1,high);
            }else{
                return find(i2,low,cur-1);
            }

        }
    }
}
