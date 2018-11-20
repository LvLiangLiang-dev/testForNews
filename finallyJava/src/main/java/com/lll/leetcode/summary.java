package com.lll.leetcode;

/**
 * Created by Fayne on 2018/03/15.
 */
public class summary {
    public static void main(String[] args) {
        int []res={3,1,6,7,9,22,33,1,98,765,423,132};
        int []res2={3,1,1,1,9,1,33,1,98,1,1,132};
        choose_topn(res,0,res.length-1,6);
        for(int i=res.length-1-6;i<res.length;i++)
            System.out.println(res[i]);

        int res1=0,tmp1=0;
        System.out.println(sum(res,res.length-1,res1));
        for(int i:res){
            tmp1+=i;
        }
        System.out.println(tmp1);

        System.out.println("more 1/2: "+more1_2(res2));
    }

    /**
     * 通过抵消法来确定 more 1/2的数字。嘿嘿
     * @param res
     * @return
     */
    private static int more1_2(int[] res) {
        int len=res.length;
        int num=0,result=res[0];

        for(int i=0;i<len;i++){
            if(result==res[i])num++;
            else{
                num--;
                if(num==0)result=res[i];
            }
        }
        return result;
    }

    /**
     * 递归求和
     * @param res
     * @param n
     * @param res1
     * @return
     */
    private static int sum(int[] res, int n, int res1) {
        if(n==0){
            return res[0];
        }
        res1=sum(res,n-1,res1)+res[n];
        return res1;
    }

    /**
     * 通过快速排序的思想解决 TopN的问题
     */
    private static void choose_topn(int[] res, int l, int r, int n) {
        int mid=(l+r)/2;
        int left=l,right=r;
        while(left<right){
            while(res[left]<=res[mid])left++;
            while(res[right]>=res[mid])right--;
            swap(res,left,right);
        }
        if(r-mid+1==n){
            return ;
        }else  if(r-mid+1>n){
            choose_topn(res,mid,r,n);
        }else{
            choose_topn(res,l,mid,n-(r-mid+1));
        }

    }


    private static void swap(int[] res, int l, int r) {
        int temp=res[l];
        res[l]=res[r];
        res[r]=temp;
    }
}
