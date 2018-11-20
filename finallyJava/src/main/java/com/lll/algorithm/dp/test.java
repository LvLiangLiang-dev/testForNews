package com.lll.algorithm.dp;

/**
 * Created by lvliangliang on 2018/03/26.
 */
public class test {
    public int q1 (int x,int y,int n){
        int []dp=new int[n+1];
        int k=Math.abs(x-y);
        dp[0]=0;
        dp[x]=1;
        dp[y]=1;
        dp[k]=2;
        for(int i=1;i<=n;i++){
            if(i>=x&&i>=y&&i>=k){
                dp[i]=Math.min(Math.min(dp[i-x]+1,dp[i-y]+1),dp[i-k]+2);
            }
        }
        return dp[n];//默认是大于x,y,k的。
    }
    public int q2(int x,int n){
        if(n==0&&x>0)return 1;
        int result=1;
        if(n>0){
            for(int i=0;i<n;i++){
                result=result*x;
            }
        }else{
            x=1/x;
            for(int i=0;i<n;i++){
                result=result*x;
            }
        }
        return result;
    }

}
class  s{
    private static s sss=new s();
    private s(){};
    public static s getInstance(){
        return sss;
    }
}

