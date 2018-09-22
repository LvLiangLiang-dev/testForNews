package Impl;

import javax.inject.Named;
import javax.inject.Singleton;

import entity.Person;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/5/18
 */

public class Student implements Person {
    public void say() {
        System.out.println("i'm student");
    }
}
