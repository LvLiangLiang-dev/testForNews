package com.lll.basics.exception;


import org.junit.Test;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：异常必须要处理
 *  如果没有try catch finally 捕获，有异常了会一层一层向外转移
 *
 * @DATE: 2018/5/10
 */
public class temp1 {
    public static void main(String[] args) {


    }
    @Test
    void q0(){
        try{
            q1();
        }catch(Exception exception){
            System.out.println("抓到q1了");
        }finally {
            System.out.println("this is finally");
        }
    }

    @Test
    void q0_1() throws Exception {
        q1();
    }

    void q1()  throws Exception{
        System.out.println(5/0);
    }
}
