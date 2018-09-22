package Impl;

import entity.LogService;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */
public class LogServiceImpl implements LogService {
    public void log(String msg) {
        System.out.println("LOG: "+msg);
    }
}
