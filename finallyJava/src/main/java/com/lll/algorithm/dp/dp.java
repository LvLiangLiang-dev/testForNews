package com.lll.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Fayne on 2018/03/16.
 */

public class  dp{
    static int count=0;
    public static void main(String []args) throws IOException {
        System.out.println(help222());
    }

    private static int help222() throws IOException {
        int res=0,j=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine().trim();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String s2 = br.readLine().trim();
        while(j<=s1.length()-s2.length()){
             for(int i=0;i<s2.length();i++)
                if(s2.charAt(i)!=s1.charAt(i+j))
                    res++;
            j++;
        }
        return res;


    }

    private static int doff() throws IOException {
        int result=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int res[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            res[i]=Integer.valueOf(s.charAt(i)-'0');
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<res.length;i++){
            map.put(res[i],map.getOrDefault(res[i],0)+1);
        }
        for(int i=1;;i++){
            String temp=String.valueOf(i);
            int num[]=new int[temp.length()];
            for(int j=0;j<temp.length();j++){
                num[j]=Integer.valueOf(temp.charAt(j)-'0');
            }
            HashMap<Integer,Integer>map2=new HashMap();
            for(int j=0;j<temp.length();j++){
                map2.put(num[j],map2.getOrDefault(num[j],0)+1);
            }
            Iterator iterator=map2.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                Integer key = (Integer) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if(map.containsKey(key)){
                    if(map.get(key)<val)
                        return i;
                }else
                    return i;
            }
        }
    }

    /**
     * lcs 之二 最长公共子串
     * 通过dp
     *  res[i][j]定义为 x[i],y[j]为结尾的最长公共子串
     *      转移方程：
     *          x[i]==y[j] res[i][j]=res[i-1][j-1]+1   i>0,j>0
     *          x[i]!=y[j] res[i][j]=0                 i>0,j>0
     *          然后判断一下最上的一行和最左的一列       i==0||j==0
     */
    private static void do_lcs2() {
        int x[]={1,2,3,6,12,7,8};
        int y[]={1,2,3,6,13,7,8};
        int len=lcs2(x,y);
        System.out.println(len);
    }

    private static int lcs2(int[] x, int[] y) {
        int [][]res=new int [x.length][y.length];

        for(int i=0;i<x.length;i++){
            if(x[0]==y[i])res[0][i]=1;
        }
        for(int i=0;i<y.length;i++){
            if(x[i]==y[0])res[i][0]=1;
        }
        for(int i=1;i<x.length;i++){
            for(int j=1;j<y.length;j++){

                if(x[i]==y[j])res[i][j]=res[i-1][j-1]+1;
            }
        }
        int temp=Integer.MIN_VALUE;
        for(int i=0;i<x.length;i++)
            for(int j=0;j<y.length;j++){
                if(res[i][j]>temp)temp=res[i][j];
            }
        return temp;
    }

    /**
     * 解决最长公共子序列的问题，通过dp
     * 主要是状态转移方程的编写
     *      if x[i]==y[j]   res[i][j]=res[i-1][j-1]+1
     *      else            res[i][j]=max( res[i-1][j],res[i][j-1])
     *
     *      至于得到最终的序列，则是通过反编译来得到路径。
     *          从
     */
    private static void do_lcs() {
        int x[]={1,2,3,6,7,8};
        int y[]={44,4,3,0,3,8};
        int len=lcs(x,y);
        System.out.println(len);
    }

    private static int lcs(int[] x, int[] y){
        int xlen=x.length;
        int ylen=y.length;
        int res[][]=new int[xlen][ylen];

        for(int i=1;i<xlen;i++)
            for(int j=1;j<ylen;j++){
                if(x[i]==y[i]){
                    res[i][j]=res[i-1][j-1]+1;
                }
                if(x[i]!=y[i]){
                    res[i][j]=Math.max(res[i-1][j],res[i][j-1]);
                }
            }
        return res[xlen-1][ylen-1];

    }

    /**
     * DP解决连加最大问题
     */
    private static void do_max_addition() {
        int res[]={-2,3,-2,4,10,-9};
        int result=max_addition(res);
        System.out.println("max_addition: "+result);
    }

    private static int max_addition(int[] res) {
        int result[]=new int [res.length];
        result[0]=res[0];
        int temp=result[0];
        for(int i=1;i<res.length;i++){
            result[i]=Math.max(result[i-1]+res[i],res[i]);
            temp=Math.max(temp,result[i]);
        }


        return temp;
    }

    /**
     *  DP解决数组中最大连续子数组乘积问题。
     */
    private static void do_max_multi() {
        int res[]={2,2,2,2,-2};
        int result=max_multi(res);
        System.out.println("result: "+result);
    }


    private static int max_multi(int[] res) {
        int  max[]=new int [res.length];
        max[0]=res[0];
        int  min[]=new int [res.length];
        min[0]=res[0];
        int last=res[0];

        for(int i=1;i<res.length;i++){
            max[i]=Math.max(res[i],Math.max(max[i-1]*res[i],min[i-1]*res[i]));
            min[i]=Math.min(res[i],Math.min(max[i-1]*res[i],min[i-1]*res[i]));
            last=Math.max(last,Math.max(max[i],min[i]));
        }
        return last;
    }

    /**
     * 通过dp解决矩阵中只能下降或者向右移动的最短路径
     *  重点就是转移方程
     */
    private static void do_minroad_from_matrix() {
        int res[][]={{1,2,3,4},{2,3,4,7},{66,1,23,98},{100,232,445,781}};
        int result=minroad(res);
        System.out.println("minroad: "+result);
    }

    private static int minroad(int[][] res) {
        int len=res.length;
        int width=res[0].length;
        int [][]temp=new int[len][width];
        temp[0][0]=res[0][0];
        for(int i=1;i<len;i++){
            temp[i][0]=temp[i-1][0]+res[i][0];
        }
        for(int i=1;i<width;i++){
            temp[0][i]=temp[0][i-1]+res[0][i];
        }
        for(int i=1;i<len;i++){
            for(int j=1;j<width;j++){
                temp[i][j]=Math.min(temp[i-1][j],temp[i][j-1])+res[i][j];
            }
        }
        return temp[len-1][width-1];


    }


    private static void tmp() {
        int n = 33;

        long result = fb1(n);
        long result2 = fb2(n);


        System.out.println("n :"+n);
        System.out.println("result: "+result);
        System.out.println("result2: "+result2);
        System.out.println("count: "+count);
    }

    private static long fb2(int n) {
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=-1;

        arr[0]=arr[1]=1;
        for(int i=2;i<n;i++)
            arr[i]=arr[i-1]+arr[i-2];
        return arr[n-1];
    }

    private static long fb1(int i) {
        count++;
        if(i==1)return 1;
        if(i==2)return 1;
        return fb1(i-1)+fb1(i-2);
    }

}

