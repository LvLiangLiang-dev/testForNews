package com.lll.algorithm.recursion;

import java.util.Scanner;

/**
 * 理解汉诺塔问题，理解递归，用数学归纳法的思想去想就没那么难了
 * 而且递归是为了简化问题，思考的时候不要展开，越展开越复杂。
 * 总之，思考一件事情先想好它的本质和存在的意义，这样细节就有了原因。
 *
 * Created by lvliangliang on 2017/12/08.
 */
public class hanoi {
    static int count=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char x='a',y='b',z='c';
        while(true){
            int n=scanner.nextInt();
            han(n,x,y,z);
            System.out.println("the all is "+count);
            System.out.println("the 2的n次方 ："+Math.pow(2,n));
        }
    }

    private static void han(int n, char begin, char mid, char result) {
        if(n==1){
            move(1,begin,result);
        }else{
            han(n-1,begin,result,mid);
            move(n,begin,result);
            han(n-1,mid,begin,result);
        }
    }

    private static void move(int i, char begin, char result) {
        count++;
        System.out.println("序号："+i+"from  "+begin+"  to  "+result);
    }


}
