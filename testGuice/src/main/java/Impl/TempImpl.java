package Impl;

import javax.inject.Named;

import entity.Temp;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */
public class TempImpl implements Temp {
    public void work() {
        System.out.println("work ok from TempImpl");
    }
}
