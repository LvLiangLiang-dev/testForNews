package com.lll.algorithm.sort;
import java.util.Arrays;

/**
 * 插入排序
 *         直接插入排序
 *         希尔排序
 * 选择排序
 *         简单选择排序
 *         堆排序 *
 * 交换排序
 *         冒泡排序
 *         快速排序
 * 归并排序
 * 基数排序
 * Created by lvliangliang on 2017/12/01.
 */
public class testSort {
    static int[] exa = {21, 3, 5, 1, 9, 6, 17, 24, 55, 10, 91, 25, 66, 41, 32, 81, 9};

    public static void main(String[] args) {
        System.out.println("exa.length= " + exa.length);
        System.out.println(Arrays.toString(exa) + "origin" + sum(exa));
        int len=exa.length;

        for(int i=len/2-1;i>=0;i--){
            bulidheap(exa,i,len);
        }
        for(int i=len-1;i>0;i--){
            swap(exa,0,i);
            bulidheap(exa,0,i);
        }
        System.out.println(Arrays.toString(exa) + "after" + sum(exa));





    }

    private static void bulidheap(int[] exa, int i, int len) {

        int temp=exa[i];
        for(int k=2*i+1;k<len;k=2*k+1){
            if(k+1<len&&exa[k]<exa[k+1]){
                k++;
            }
            if(temp<exa[k]){
                exa[i]=exa[k];
                i=k;
            }else{
                break;
            }
        }
        exa[i]=temp;


    }

    private static void swap(int[] exa, int max, int i) {
        int temp=exa[max];
        exa[max]=exa[i];
        exa[i]=temp;
    }


    /**
     * 交换排序值快速排序
     *
     * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
     * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
     * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
     *
     * 通过递归的方法，能够很好的将这种排序得到最终的结果。
     *
     *
     * 当有序性特别好的时候，快速排序的效率会退化成n2,递归树的深度接近n，而不是归并排序必然的logn
     * 随机的话，期望值是 nlogn
     *
     * 优化：人为随机，互换后面随机的下标与第一个数的位置，这样将有可能的有序性好的数组变为一般的数组，
     *          会大大提高有序性好的数组的快速排序的时间复杂度。
     */
    public static void quickSort() {
        recuriveQuickSort(exa,0,exa.length-1);
        System.out.println(Arrays.toString(exa) + "quickSort"+sum(exa));
    }
    private static void recuriveQuickSort(int[] exa, int i, int i1) {
        if(i<i1){
            int middle=getMiddle(exa,i,i1);
            recuriveQuickSort(exa,i,middle-1);
            recuriveQuickSort(exa,middle+1,i1);
        }
    }
    private static int getMiddle(int[] exa, int i, int i1) {
        int temp=exa[i];
        while(i<i1){
            while(i<i1&&temp<=exa[i1]){
                i1--;
            }
            exa[i]=exa[i1];
            while(i<i1&&temp>=exa[i]){
                i++;
            }
            exa[i1]=exa[i];
        }
        exa[i]=temp;
        return i;
    }

    /**
     * 交换排序之冒泡排序
     * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     *
     * 如果是升序，最大的就会在一次循环中沉到最低，所以下次循环时就不用到最后一个了，就到最后一个的上一个就行了。
     * 降序也同理，也会这么操作。
     */

    public static void bubbleSort() {
        int temp=0;
        for(int i=0;i<exa.length;i++){
            for(int j=0;j<exa.length-i-1;j++){
                if(exa[j+1]<exa[j]){
                    temp=exa[j];
                    exa[j]=exa[j+1];
                    exa[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(exa) + "bubbleSort"+sum(exa));
    }

    public static int sum(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }
    /**
     * 选择排序之堆排序
     *
     * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     *
     */
    public static void heapSort() {

    }

    /**
     * 选择排序之简单选择排序
     * <p>
     * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
     */
    public static void simpleSelect() {
        for (int i = 0; i < exa.length; i++) {
            int temp = exa[i], position = i;
            for (int j = i + 1; j < exa.length; j++) {
                if (temp > exa[j]) {
                    temp = exa[j];
                    position = j;
                }
            }
            exa[position] = exa[i];
            exa[i] = temp;
        }
        System.out.println(Arrays.toString(exa) + "simpleSelect"+sum(exa));
    }


    /**
     * 插入排序之希尔排序
     * <p>
     * 也称递减增量排序算法，是插入排序的一种更高级的改进版本。
     * 非稳定排序算法
     */
    public static void shellSort() {
        int gap = 1;
        int i, j, temp;
        while (gap < exa.length / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap = gap / 3) {
            for (i = gap; i < exa.length; i++) {
                temp = exa[i];
                for (j = i - gap; j >= 0 && exa[j] > temp; j -= gap) {
                    exa[j + gap] = exa[j];
                }
                exa[j + gap] = temp;
            }
        }
        System.out.println(Arrays.toString(exa) + "shellSort" + sum(exa));
    }

    /**
     * 插入排序之直接插入排序
     * <p>
     * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排
     * 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
     * 也是排好顺序的。如此反复循环，直到全部排好顺序。
     *
     * 以下是改进后的插入排序，不改进的话，是每次比较无果后就要交换直到正确位置才停止交换，
     * 而一次交换是三次赋值，下面这种改进将三次赋值变为一次赋值，会大大降低时间复杂度。
     *
     * 这种改进 不旦 没有用 交换这种操作，还可以提前终止内层循环，
     *       提前终止是非常有效的特性。
     * 所以对有序性很高的数组，插入排序的效率极高！！！比n*logn级别的效率还要高！
     *
     *
     * 除了简单插入排序，希尔排序也和简单插入排序一脉相乘，只不过是按照一定距离
     *
     */
    public static void directInsertSort() {
        for (int i = 1; i < exa.length; i++) {
            int temp = exa[i];
            int j = i - 1;
            for (; j >= 0 && exa[j] > temp; j--) {
                exa[j + 1] = exa[j];
            }
            exa[j + 1] = temp;
        }
        System.out.println(Arrays.toString(exa) + "directInsertSort");
    }
}
