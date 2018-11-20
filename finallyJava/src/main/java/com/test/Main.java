package com.test;

/**
 * Created by Fayne on 2018/03/24.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer>temp=new ArrayList<>();
    }


    private static void q3() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []res=new int[n];
        int l=1,r=1;
        for(int i=0;i<n;i++){
            String a=in.next();
            for(int j=0;j<a.length();j++) {
                if (a.charAt(j) == '+') {
                    l = Integer.valueOf(a.substring(0, j  ));
                    r = Integer.valueOf(a.substring(j + 1, a.length()  ));
                    res[i] = l + r;
                }
                if (a.charAt(j) == '-') {
                    l = Integer.valueOf(a.substring(0, j  ));
                    r = Integer.valueOf(a.substring(j + 1, a.length() ));
                    res[i] = l - r;
                }
                if (a.charAt(j) == '*') {
                    l = Integer.valueOf(a.substring(0, j));
                    r = Integer.valueOf(a.substring(j + 1, a.length() ));
                    res[i] = l * r;
                }
            }
        }
        String []a0=new String[6];
        a0[0]="66666";
        a0[1]="6...6";
        a0[2]="6...6";
        a0[3]="6...6";
        a0[4]="66666";
        String []a1=new String[6];
        a1[0]="....6";
        a1[1]="....6";
        a1[2]="....6";
        a1[3]="....6";
        a1[4]="....6";
        String []a2=new String[6];
        a2[0]="66666";
        a2[1]="....6";
        a2[2]="66666";
        a2[3]="6....";
        a2[4]="66666";
        String []a3=new String[6];
        a3[0]="66666";
        a3[1]="....6";
        a3[2]="66666";
        a3[3]="....6";
        a3[4]="66666";
        String []a4=new String[6];
        a4[0]="6...6";
        a4[1]="6...6";
        a4[2]="66666";
        a4[3]="....6";
        a4[4]="....6";
        String []a5=new String[6];
        a5[0]="66666";
        a5[1]="6....";
        a5[2]="66666";
        a5[3]="....6";
        a5[4]="66666";
        String []a6=new String[6];
        a6[0]="66666";
        a6[1]="6....";
        a6[2]="66666";
        a6[3]="6...6";
        a6[4]="66666";
        String []a7=new String[6];
        a7[0]="66666";
        a7[1]="....6";
        a7[2]="....6";
        a7[3]="....6";
        a7[4]="....6";
        String []a8=new String[6];
        a8[0]="66666";
        a8[1]="6...6";
        a8[2]="66666";
        a8[3]="6...6";
        a8[4]="66666";
        String []a9=new String[6];
        a9[0]="66666";
        a9[1]="6...6";
        a9[2]="66666";
        a9[3]="....6";
        a9[4]="66666";
        String []ax=new String[6];
        ax[0]="..";
        ax[1]="..";
        ax[2]="..";
        ax[3]="..";
        ax[4]="..";
        for(int i=0;i<n;i++){
            char temp[]=String.valueOf(res[i]).toCharArray();
            String []result=new String[5];
            for(int kkkk=0;kkkk<5;kkkk++)result[kkkk]="";
            for(int j=0;j<5;j++){
                for(int len=0;len<temp.length;len++){

                    if(temp[len]=='0'){
                        if(len==temp.length-1) result[j]=result[j]+a0[j];
                        else result[j]=result[j]+a0[j]+ax[j];
                    }
                    if(temp[len]=='1'){
                        if(len==temp.length-1) result[j]=result[j]+a1[j];
                        else result[j]=result[j]+a1[j]+ax[j];
                    }
                    if(temp[len]=='2'){
                        if(len==temp.length-1) result[j]=result[j]+a2[j];
                        else result[j]=result[j]+a2[j]+ax[j];
                    }
                    if(temp[len]=='3'){
                        if(len==temp.length-1) result[j]=result[j]+a3[j];
                        else result[j]=result[j]+a3[j]+ax[j];
                    }
                    if(temp[len]=='4'){
                        if(len==temp.length-1) result[j]=result[j]+a4[j];
                        else result[j]=result[j]+a4[j]+ax[j];
                    }
                    if(temp[len]=='5'){
                        if(len==temp.length-1) result[j]=result[j]+a5[j];
                        else result[j]=result[j]+a5[j]+ax[j];
                    }
                    if(temp[len]=='6'){
                        if(len==temp.length-1) result[j]=result[j]+a6[j];
                        else result[j]=result[j]+a6[j]+ax[j];
                    }
                    if(temp[len]=='7'){
                        if(len==temp.length-1) result[j]=result[j]+a7[j];
                        else result[j]=result[j]+a7[j]+ax[j];
                    }
                    if(temp[len]=='8'){
                        if(len==temp.length-1) result[j]=result[j]+a8[j];
                        else result[j]=result[j]+a8[j]+ax[j];
                    }
                    if(temp[len]=='9'){
                        if(len==temp.length-1) result[j]=result[j]+a9[j];
                        else result[j]=result[j]+a9[j]+ax[j];
                    }
                }

            }
            for(int kk=0;kk<5;kk++)
                System.out.println(result[kk]);

        }
    }

    private static void q5() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int h = in.nextInt();
        int data[]=new int[n];
        for(int i=0;i<n;i++)
            data[i]=in.nextInt();
        int []dp=new int[k+1];
        dp[0]=0;
        int temp=0;
        for(int i=1;i<k+1;i++){
            for(int j=0;j<n;j++){
                if(dp[i-1]+h>data[j])
                    temp=data[j-1];
            }
            dp[i]=(temp-dp[i-1])*2+dp[i-1];
        }
        System.out.println(dp[k]);
    }

    private static void q1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int data[]=new int[n];
        for(int i=0;i<n;i++)
           data[i]=in.nextInt();
        int  res = 0;
        Arrays.sort(data);
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> sameSet = new HashSet<Integer>();
        if (k != 0) {
            for (int i = 0; i < n; i++) {
                if (!set.contains(data[i]) && set.contains(data[i] - k))
                    res++;
                set.add(data[i]);
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!sameSet.contains(data[i]) && set.contains(data[i])) {
                    res++;
                    sameSet.add(data[i]);
                }
                set.add(data[i]);
            }
        }
        System.out.println(res);
    }

}
