package com.test;

/**
 * Created by Fayne on 2018/09/18.
 */
public class DIDI1 {
    public static void main(String[] args) {
        for (int i = 9; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print(i + "*" + j + "=" + (i * j));
                if(i*j>=10) System.out.print(" ");
                if(i*j<10) System.out.print("  ");
            }
            System.out.println();
            for (int t = 10; t > i; t--) {
                System.out.print("       ");
            }
        }

    }
}
