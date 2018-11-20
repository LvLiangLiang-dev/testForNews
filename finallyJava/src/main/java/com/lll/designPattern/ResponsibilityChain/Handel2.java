package com.lll.designPattern.ResponsibilityChain;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/7/27
 */
public class Handel2 extends Handel {
    @Override
    public void request(int request) {
        if(request>10){
            System.out.println("i'm handel_2: "+request);
        }else{
            System.out.println("there isn't other handels");
        }
    }
}
