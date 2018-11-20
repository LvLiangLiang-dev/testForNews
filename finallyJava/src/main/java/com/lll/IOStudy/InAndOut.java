package com.lll.IOStudy;

import java.util.LinkedList;

/**
 * java 输入输出在这里测试。
 *
 *
 * Created by lvliangliang on 2017/11/20.
 */
public class InAndOut {
    public static void main(String [] args){
        testlist();
    }

    /**
     * 可以直接输出list，能类似数组一样输出。
     * 也可以用循环输出列表中的每一个。
     */
    public static void testlist() {
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(9);
        list.add(6);
        System.out.println(list);
        for(Integer temp:list){
            System.out.println(temp.toString());
        }
        for(Integer temp:list){
            System.out.println(temp);
        }
    }
}
