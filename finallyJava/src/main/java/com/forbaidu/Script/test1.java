package com.forbaidu.Script;

import java.util.Random;

import org.junit.Test;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/21
 */
public class test1 {
    public static void main(String[] args) {

    }
    @Test
    public void getDemoDATA(){
        for (int i = 0; i < 100; i++) {
            String name=new String(String.valueOf(getRandomCharacter('a', 'z')))+new String(String.valueOf(getRandomCharacter('a', 'z')));
            int age =new Random().nextInt(100);
            String tel =getRandomTel();
            System.out.println(i + "," +name+ ','+age+","+tel);
        }
        System.out.println("");
    }
    public   String getRandomTel(){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<11;i++){
            sb.append(new Random().nextInt(9));
        }
        return new String(sb);
    }


    public  char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));//因为random<1.0，所以需要+1，才能取到ch2
    }
}
