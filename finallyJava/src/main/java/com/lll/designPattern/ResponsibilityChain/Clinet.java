package com.lll.designPattern.ResponsibilityChain;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/7/27
 */
public class Clinet {
    public static void main(String[] args) {
        Handel1 handel1=new Handel1();
        Handel2 handel2=new Handel2();
        handel1.setNextHandel(handel2);
        int [] request={1,2,3,10,19,23};
        for(int i:request){
            handel1.request(i);
        }

    }
}
