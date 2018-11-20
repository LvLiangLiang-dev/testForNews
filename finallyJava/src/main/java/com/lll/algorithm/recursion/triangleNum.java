package com.lll.algorithm.recursion;

import java.util.Scanner;

/**
 * 三角数字， 当前项=当前项序号+前一项大小。
 *
 * Created by lvliangliang on 2017/12/08.
 */
public class triangleNum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int temp=scanner.nextInt();
            System.out.println(temp +": "+triangle(temp));
        }
    }

    private static int triangle(int b) {
        if(b==1)return 1;
        return b+triangle(b-1);
    }
}
